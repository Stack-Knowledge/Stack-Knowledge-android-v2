package com.stackknowledge.dto.response.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stackknowledge.dto.user.User
import java.util.UUID

@JsonClass(generateAdapter = true)
data class DetailSolveMissionResponse(
    @Json(name = "solveId") val solveId: UUID,
    @Json(name = "title") val title: String,
    @Json(name = "solution") val solution: String
)
