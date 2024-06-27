package remote.response.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import enumdatatype.MissionStatus
import remote.user.UserModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class MissionsModel(
    @Json(name = "id") val id: UUID,
    @Json(name = "title") val title: String,
    @Json(name = "point") val point: Int,
    @Json(name = "missionStatus") val missionStatus: MissionStatus,
    @Json(name = "user") val user: UserModel,
)
