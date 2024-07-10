package com.stackknowledge.dto.request.order

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderRequest (
    @Json(name = "body") val orders: Orders,
)