package response.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailMissionResponse(
    @Json(name = "title") val title : String,
    @Json(name = "content") val content : String,
    @Json(name = "timeLimit") val timeLimit: Int,
)