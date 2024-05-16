package com.stackknowledge.dto.response.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.datetime.LocalDateTime
import java.util.UUID

@JsonClass(generateAdapter = true)
data class GetRequestSignUpTeacherResponse(
    @Json(name = "userId") val userId: UUID,
    @Json(name = "name") val name: String,
    @Json(name = "createdAt") val createdAt: LocalDateTime
)
