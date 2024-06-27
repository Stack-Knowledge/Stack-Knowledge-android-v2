package com.stackknowledge.dto.request.order

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.UUID

@JsonClass(generateAdapter = true)
data class Orders (
    @Json(name = "itemId") val itemId: UUID,
    @Json(name = "count") val count: Int,
)