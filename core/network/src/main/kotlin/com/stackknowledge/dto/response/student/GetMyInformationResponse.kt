package com.stackknowledge.dto.response.student

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stackknowledge.dto.user.User
import java.util.UUID

@JsonClass(generateAdapter = true)
data class GetMyInformationResponse(
    @Json(name = "id") val id: String,
    @Json(name = "currentPoint") val currentPoint: Int,
    @Json(name = "cumulatePoint") val cumulatePoint: Int,
    @Json(name = "ranking") val ranking: Int,
    @Json(name = "user") val user: User,
)