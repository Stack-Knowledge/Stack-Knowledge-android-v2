package com.stackknowledge.util

<<<<<<< HEAD
import com.example.common.exception.NeedLoginException
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.stackknowledge.network.BuildConfig
import com.stackknowledge.datastore.LocalAuthDataSource
import kotlinx.coroutines.flow.first
=======
>>>>>>> 7968c9bc41ecc66967c282ccfb3222e458eb598b
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import util.ResourceKeys
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val dataSource: LocalAuthDataSource
): Interceptor {

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    data class TokenResponse(
        val accessToken: String,
        val refreshToken: String,
        val expiredAt: String
    )

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
<<<<<<< HEAD
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
                    val response = client.newCall(refreshRequest).execute()
                    if (response.isSuccessful) {
                        val adapter = moshi.adapter(TokenResponse::class.java)
                        val tokenResponse = adapter.fromJson(response.body!!.string())

                        tokenResponse?.let {
                            dataSource.setAccessToken(it.accessToken)
                            dataSource.setRefreshToken(it.refreshToken)
                            dataSource.setAccessTime(it.expiredAt)
                            dataSource.setRefreshTime(it.expiredAt)
                        } ?: throw NeedLoginException()
                    } else throw NeedLoginException()
                }
            }
            val accessToken = dataSource.getAccessToken().first().replace("\"", "")
            builder.addHeader("Authorization", "Bearer $accessToken")
=======

        runBlocking {
            builder.addHeader("Authorization", "${ResourceKeys.BEARER} ")
>>>>>>> 7968c9bc41ecc66967c282ccfb3222e458eb598b
        }
        return chain.proceed(builder.build())
    }
}
