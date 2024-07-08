package remote.item

import java.util.UUID

data class ItemModel(
    val id: String,
    val name: String,
    val price: Int,
    val image: String,
)