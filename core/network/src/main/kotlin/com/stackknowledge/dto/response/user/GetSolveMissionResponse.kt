package com.stackknowledge.dto.response.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stackknowledge.dto.user.User
import java.util.UUID

@JsonClass(generateAdapter = true)
data class GetSolveMissionResponse(
    @Json(name = "solveId") val solveId: UUID,
    @Json(name = "solveStatus") val solveStatus: String,
    @Json(name = "title") val title: String,
    @Json(name = "point") val point: Int,
    @Json(name = "user") val user: User
)
