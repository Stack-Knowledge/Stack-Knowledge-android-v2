package remote.request.order


data class OrderRequestModel (
    val itemId: String,
    val count: Int,
)