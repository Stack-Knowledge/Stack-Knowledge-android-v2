package remote.response.student

import java.util.UUID

data class GetStudentPointRankingResponse(
    val id: UUID,
    val cumulatePoint: Int,
    val user: User,
) {
    data class User(
        val id: UUID,
        val name: String,
        val profileImage: String,
    )
}
