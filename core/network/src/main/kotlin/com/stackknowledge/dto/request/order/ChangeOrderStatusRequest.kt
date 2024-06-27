package com.stackknowledge.dto.request.order

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.UUID

@JsonClass(generateAdapter = true)
data class ChangeOrderStatusRequest (
    @Json(name = "orderId") val orderId: UUID,
    @Json(name = "count") val count: Int,
)