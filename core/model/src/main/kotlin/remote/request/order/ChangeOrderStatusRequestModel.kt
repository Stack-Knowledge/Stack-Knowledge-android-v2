package remote.request.order

import java.util.UUID

data class ChangeOrderStatusRequestModel(
    val orderId: String,
    val count: Int,
)