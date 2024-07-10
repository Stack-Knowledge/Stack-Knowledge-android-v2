package com.stackknowledge.dto.response.item

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stackknowledge.dto.item.Item

@JsonClass(generateAdapter = true)
data class GetItemResponse(
    @Json(name = "body") val items: Item
)
