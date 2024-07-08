package remote.request.order

import java.util.UUID


data class OrderRequestModel (
    val itemId: String,
    val count: Int,
)