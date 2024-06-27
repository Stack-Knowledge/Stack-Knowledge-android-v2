package remote.response.student

import remote.user.UserModel
import java.util.UUID

data class GetStudentPointRankingResponse(
    val id: UUID,
    val cumulatePoint: Int,
    val user: UserModel,
)
