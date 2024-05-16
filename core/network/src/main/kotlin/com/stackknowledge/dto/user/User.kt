package com.stackknowledge.dto.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.UUID

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id") val id: UUID,
    @Json(name = "name") val name: String,
    @Json(name = "profileImage") val profileImage: String,
)
