package remote.response.user

import remote.user.UserModel
import java.util.UUID

data class GetSolveMissionResponseModel(
    val solveId: UUID,
    val solveStatus: String,
    val title: String,
    val point: Int,
    val user: UserModel,
)
