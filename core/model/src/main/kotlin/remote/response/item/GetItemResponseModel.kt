package remote.response.item

import java.util.UUID

data class GetItemResponseModel(
    val id: UUID,
    val name: String,
    val price: Int,
    val image: String,
    )