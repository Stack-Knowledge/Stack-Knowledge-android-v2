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
            builder.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjMDJjZDIzMC01ZTFkLTQwNGQtOGEwZC04M2U0ZjVjYTRjNDUiLCJ0eXBlIjoiYWNjZXNzIiwiYXV0aG9yaXR5IjoiUk9MRV9TVFVERU5UIiwiaWF0IjoxNzE5ODgwMzQyLCJleHAiOjE3MTk4ODIxNDJ9.7teecu_t_1FxVdEc5MHJ3LXLPpRI3mQN4qH5WGI0Sb0")
        }
        return chain.proceed(builder.build())
    }
}