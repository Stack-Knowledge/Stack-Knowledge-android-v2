package com.stackknowledge.dto.response.item

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetItemResponse(
    @Json(name = "itemId") val itemId: String,
    @Json(name = "name") val name: String,
    @Json(name = "price") val price: Int,
    @Json(name = "image") val image: String,
)
