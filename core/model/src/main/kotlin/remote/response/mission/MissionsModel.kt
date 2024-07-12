package remote.response.mission

import enumdata.MissionStatus
import remote.user.UserModel
import java.util.UUID

data class MissionsModel(
    val id: UUID,
    val title: String,
    val point: Int,
    val missionStatus: MissionStatus,
    val user: UserModel,
)
