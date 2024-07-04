package com.stackknowledge.util

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        runBlocking {
            builder.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZjQzNzZjOS03MmZhLTQxYjQtYTg0NS04ZmYxNTQ2MzU4MTEiLCJ0eXBlIjoiYWNjZXNzIiwiYXV0aG9yaXR5IjoiUk9MRV9URUFDSEVSIiwiaWF0IjoxNzIwMDgyMjk0LCJleHAiOjE3MjAwODQwOTR9.Jvyx3XH3URBBF-5bfb-YxP_agLq3bFdXqsnSOk0l-W8")
        }
        return chain.proceed(builder.build())
    }
}