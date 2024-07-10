package remote.response.student

import remote.user.UserModel
import java.util.UUID

data class GetStudentPointRankingResponseModel(
    val id: String,
    val cumulatePoint: Int,
    val user: UserModel,
)
