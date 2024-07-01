package com.stackknowledge.api

import remote.request.auth.LoginRequest
import remote.response.auth.LoginResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface AuthAPI {
    @POST("/auth/student")
    suspend fun loginStudent(
        @Body body: LoginRequest,
    ): LoginResponse

    @POST("/auth/teacher")
    suspend fun loginTeacher(
        @Body body: LoginRequest,
    ): LoginResponse

    @DELETE("/auth")
    suspend fun logout()
}
