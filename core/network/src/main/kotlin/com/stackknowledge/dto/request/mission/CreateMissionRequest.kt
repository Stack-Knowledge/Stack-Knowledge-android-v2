package com.stackknowledge.dto.request.mission

<<<<<<< HEAD
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateMissionRequest (
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "timeLimit") val timeLimit: Int,
)
=======
data class CreateMissionRequest(
    val title: String,
    val content: String,
    val timeLimit: Int,
)
>>>>>>> origin/feature/#46_mission_domain_network_setting
