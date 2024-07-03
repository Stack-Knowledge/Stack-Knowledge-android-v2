package remote.response.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import enumdatatype.MissionStatus
import remote.user.UserModel
import java.util.UUID

data class MissionResponseModel(
    val id: UUID,
    val title: String,
    val point: Int,
    val missionStatus: MissionStatus,
    val user: UserModel,
)