package remote.response.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MissionResponseModel(
    @Json(name = "body") val missions: MissionsModel,
)