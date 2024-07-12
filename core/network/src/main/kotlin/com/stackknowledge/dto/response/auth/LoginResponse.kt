package com.stackknowledge.dto.response.auth

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import enumdata.Authority

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "accessToken") val accessToken: String,
    @Json(name = "refreshToken") val refreshToken: String,
    @Json(name = "expiredAt") val expiredAt: String,
    @Json(name = "authority") val authority: Authority,
)