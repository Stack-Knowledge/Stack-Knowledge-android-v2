package com.stackknowledge.network.api

import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import com.stackknowledge.model.remote.response.auth.LoginResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

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