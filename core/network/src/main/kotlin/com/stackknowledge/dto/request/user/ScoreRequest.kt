package com.stackknowledge.dto.request.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScoreRequest(
    @Json(name = "solveStatus") val solveStatus: String,
)