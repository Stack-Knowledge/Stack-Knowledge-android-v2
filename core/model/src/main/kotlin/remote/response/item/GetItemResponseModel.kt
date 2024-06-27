package remote.response.item

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import remote.item.ItemModel

@JsonClass(generateAdapter = true)
data class GetItemResponseModel (
    @Json(name = "body") val items: ItemModel
)