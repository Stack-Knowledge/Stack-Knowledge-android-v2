package remote.response.student

import remote.user.UserModel
import java.util.UUID

data class GetMyInformationResponse(
    val id: UUID,
    val currentPoint: Int,
    val cumulatePoint: Int,
    val user: UserModel,
)