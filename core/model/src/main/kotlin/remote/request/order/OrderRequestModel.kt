package remote.request.order

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderRequestModel (
    @Json(name = "body") val orders: OrdersModel,
)