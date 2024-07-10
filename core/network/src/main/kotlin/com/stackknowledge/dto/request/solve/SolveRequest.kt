package com.stackknowledge.dto.request.solve

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SolveRequest (
    @Json(name = "solution") val solution: String,
)