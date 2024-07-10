package remote.response.order

import remote.item.ItemModel
import remote.user.UserModel
import java.util.UUID

data class ViewAllOrderResponseModel(
    val id: String,
    val count: Int,
    val price: Int,
    val item: ItemModel,
    val user: UserModel,
)
