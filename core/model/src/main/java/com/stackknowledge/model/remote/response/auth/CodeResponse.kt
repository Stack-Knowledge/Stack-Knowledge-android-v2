package com.stackknowledge.model.remote.response.auth

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthCodeResponse(
    @Json(name = "code") val code: String
)