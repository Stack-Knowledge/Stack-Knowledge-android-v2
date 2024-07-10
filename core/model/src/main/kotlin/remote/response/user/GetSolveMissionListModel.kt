package remote.response.user

import remote.user.UserModel

data class GetSolveMissionListModel (
    val solveId: String,
    val solveStatus: String,
    val title: String,
    val point: Int,
    val user: UserModel,
)