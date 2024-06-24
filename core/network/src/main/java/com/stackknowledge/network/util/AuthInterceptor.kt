package com.stackknowledge.network.util

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.stackknowledge.network.BuildConfig
import com.stackknowledge.datastore.LocalAuthDataSource
import com.stackknowledge.network.exception.NeedLoginException
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val dataSource: LocalAuthDataSource
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val currentTime = System.currentTimeMillis().toLocalDateTime()
        val ignorePath = listOf("/auth")
        val ignoreMethod = listOf("POST")
        val path = request.url.encodedPath
        val method = request.method

        ignorePath.forEachIndexed { index, s ->
            if (path.contains(s) && ignoreMethod[index] == method)
                return chain.proceed(request)
        }

        runBlocking {
            val refreshTime = dataSource.getRefreshTime().first().replace("\"", "")
            val accessTime = dataSource.getAccessTime().first().replace("\"", "")

            if (refreshTime == "") {
                return@runBlocking
            }

            if (currentTime != null) {
                if (currentTime.isAfter(refreshTime.toLocalDateTime())) {
                    throw NeedLoginException()
                }
            }

            // access 토큰 재 발급
            if (currentTime != null) {
                if (currentTime.isAfter(accessTime.toLocalDateTime())) {
                    val client = OkHttpClient()
                    val refreshRequest = Request.Builder()
                        .url(BuildConfig.BASE_URL + "/auth")
                        .patch(chain.request().body ?: RequestBody.create(null, byteArrayOf()))
                        .addHeader(
                            "Refresh-Token",
                            dataSource.getRefreshToken().first().replace("\"", "")
                        )
                        .build()
                    val jsonParser = JsonParser()
                    val response = client.newCall(refreshRequest).execute()
                    if (response.isSuccessful) {
                        val token = jsonParser.parse(response.body!!.string()) as JsonObject
                        dataSource.setAccessToken(token["accessToken"].toString())
                        dataSource.setRefreshToken(token["refreshToken"].toString())
                        dataSource.setAccessTime(token["expiredAt"].toString())
                        dataSource.setRefreshTime(token["expiredAt"].toString())
                    } else throw NeedLoginException()
                }
            }
            val accessToken = dataSource.getAccessToken().first().replace("\"", "")
            builder.addHeader("Authorization", "Bearer $accessToken")
        }
        return chain.proceed(builder.build())
    }
}