package com.stackknowledge.network.api

import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import com.stackknowledge.model.remote.response.auth.AuthCodeResponse
import com.stackknowledge.model.remote.response.auth.LoginResponse
import com.stackknowledge.network.BuildConfig
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface AuthAPI {
    @POST("/auth/{role}")
    suspend fun login(
        @Body body: LoginRequest,
        @Path("role") role: Authority
    ): LoginResponse

    @DELETE("/auth")
    suspend fun logout()

    @POST
    suspend fun requestAuthCode(
        @Url url: String = "https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount",
        @Query("response_type") code: String,
        @Query("redirect_uri") redirectUri: String = BuildConfig.REDIRECT_URI,
        @Query("scope") scope: String = BuildConfig.SCOPE,
        @Query("client_id") clientId: String = BuildConfig.GOOGLE_CLIENT_ID
    ): AuthCodeResponse
}