package com.stackknowledge.dto.item

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.UUID

@JsonClass(generateAdapter = true)
data class Item (
    @Json(name= "itemId") val itemId: String,
    @Json(name = "name") val name: String,
    @Json(name = "price") val price: Int,
    @Json(name = "image") val image: String,
)