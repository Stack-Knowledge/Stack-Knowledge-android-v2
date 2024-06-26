package remote.response.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import enumdatatype.MissionStatus
import remote.user.UserModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class MissionResponseModel(
    @Json(name = "body") val missions: MissionsModel,
)