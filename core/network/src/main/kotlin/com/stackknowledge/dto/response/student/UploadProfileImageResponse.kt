package com.stackknowledge.dto.response.student

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UploadProfileImageResponse(
    @Json(name = "fileName") val fileName: String,
)