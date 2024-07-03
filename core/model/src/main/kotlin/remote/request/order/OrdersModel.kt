package remote.request.order

import java.util.UUID

data class OrdersModel(
    val itemId: UUID,
    val count: Int,
)