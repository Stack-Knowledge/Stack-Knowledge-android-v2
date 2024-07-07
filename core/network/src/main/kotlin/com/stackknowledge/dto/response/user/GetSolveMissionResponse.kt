package com.stackknowledge.dto.response.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetSolveMissionResponse(
    @Json(name = "response") val response: List<GetSolveMissionList>,
)
