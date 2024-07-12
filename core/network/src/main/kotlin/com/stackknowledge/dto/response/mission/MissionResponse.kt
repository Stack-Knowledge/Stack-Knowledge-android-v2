package com.stackknowledge.dto.response.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stackknowledge.dto.user.User

@JsonClass(generateAdapter = true)
data class MissionResponse(
    @Json(name = "id") val id: String,
    @Json(name = "title") val title: String,
    @Json(name = "point") val point: Int,
    @Json(name = "missionStatus") val missionStatus: String,
    @Json(name = "user") val user: User,
)