package com.stackknowledge.dto.response.student

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stackknowledge.dto.user.User
import remote.user.UserModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class GetStudentPointRankingResponse(
    @Json(name = "id") val id: String,
    @Json(name = "cumulatePoint") val cumulatePoint: Int,
    @Json(name = "user") val user: User,
)
