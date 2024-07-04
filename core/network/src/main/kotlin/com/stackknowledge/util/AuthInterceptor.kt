package com.stackknowledge.util

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import util.ResourceKeys
import javax.inject.Inject

class AuthInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        runBlocking {
            builder.addHeader("Authorization", "${ResourceKeys.BEARER} ")
        }
        return chain.proceed(builder.build())
    }
}