package remote.response.user

import kotlinx.datetime.LocalDateTime
import java.util.UUID

data class GetRequestSignUpTeacherResponseModel(
    val userId: UUID,
    val name: String,
    val createdAt: LocalDateTime
)
