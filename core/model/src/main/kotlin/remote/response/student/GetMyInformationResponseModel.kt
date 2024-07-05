package remote.response.student

import remote.user.UserModel
import java.util.UUID

data class GetMyInformationResponseModel(
    val id: String,
    val currentPoint: Int,
    val cumulatePoint: Int,
    val user: UserModel,
)