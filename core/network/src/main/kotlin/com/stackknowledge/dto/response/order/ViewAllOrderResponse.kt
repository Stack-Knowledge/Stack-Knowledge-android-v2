package com.stackknowledge.dto.response.order

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stackknowledge.dto.item.Item
import com.stackknowledge.dto.user.User
import java.util.UUID

@JsonClass(generateAdapter = true)
data class ViewAllOrderResponse (
    @Json(name = "id") val id: UUID,
    @Json(name = "count") val count: Int,
    @Json(name = "price") val price: Int,
    @Json(name = "item") val item: Item,
    @Json(name = "user") val user: User,
)