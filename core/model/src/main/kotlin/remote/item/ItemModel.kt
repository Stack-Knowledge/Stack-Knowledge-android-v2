package remote.item

import java.util.UUID

data class ItemModel(
    val itemId: String,
    val name: String,
    val price: Int,
    val image: String,
)