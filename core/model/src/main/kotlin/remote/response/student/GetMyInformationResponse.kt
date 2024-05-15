package remote.response.student

import java.util.UUID

data class GetMyInformationResponse(
    val id: UUID,
    val currentPoint: Int,
    val cumulatePoint: Int,
    val user: User,
    ) {
    data class User(
        val id: UUID,
        val name: String,
        val profileImage: String?
    )
}