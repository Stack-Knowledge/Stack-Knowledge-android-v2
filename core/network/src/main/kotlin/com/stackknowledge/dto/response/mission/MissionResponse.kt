package com.stackknowledge.dto.response.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MissionResponse(
    @Json(name = "body") val missions : Missions,
)