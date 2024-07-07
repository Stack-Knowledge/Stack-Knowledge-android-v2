package com.stackknowledge.dto.response.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stackknowledge.dto.user.User

@JsonClass(generateAdapter = true)
data class GetSolveMissionList (
    @Json(name = "solveId") val solveId: String,
    @Json(name = "solveStatus") val solveStatus: String,
    @Json(name = "title") val title: String,
    @Json(name = "point") val point: Int,
    @Json(name = "user") val user: User,
)