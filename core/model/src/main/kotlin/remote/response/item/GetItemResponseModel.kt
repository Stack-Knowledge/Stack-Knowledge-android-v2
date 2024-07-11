package remote.response.item

import java.util.UUID

data class GetItemResponseModel(
    val id: String,
    val name: String,
    val price: Int,
    val image: String,
)