package response.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import enumdatatype.MissionStatus
import response.user.UserResponse
import java.util.UUID

@JsonClass(generateAdapter = true)
data class MissionResponse(
    @Json(name = "body") val missions : Missions,
)

@JsonClass(generateAdapter = true)
data class Missions(
    @Json(name = "id") val id : UUID,
    @Json(name = "title") val title : String,
    @Json(name = "point") val point : Int,
    @Json(name = "missionStatus") val missionStatus : MissionStatus,
    @Json(name = "user") val user : UserResponse,
)