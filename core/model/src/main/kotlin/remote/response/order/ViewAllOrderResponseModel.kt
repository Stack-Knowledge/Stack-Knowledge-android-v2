package remote.response.order

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import remote.item.ItemModel
import remote.user.UserModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class ViewAllOrderResponseModel (
    @Json(name = "id") val id: UUID,
    @Json(name = "count") val count: Int,
    @Json(name = "price") val price: Int,
    @Json(name = "item") val item: ItemModel,
    @Json(name = "user") val user: UserModel,
)
