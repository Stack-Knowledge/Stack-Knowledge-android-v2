package remote.response.mission

import enumdatatype.MissionStatus
import remote.user.UserModel
import java.util.UUID

data class MissionResponseModel(
    val id: String,
    val title: String,
    val point: Int,
    val missionStatus: String,
    val user: UserModel,
)