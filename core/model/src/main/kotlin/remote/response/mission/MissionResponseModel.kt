package remote.response.mission

import remote.user.UserModel

data class MissionResponseModel(
    val id: String,
    val title: String,
    val point: Int,
    val missionStatus: String,
    val user: UserModel,
)