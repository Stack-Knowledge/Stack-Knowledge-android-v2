package remote.user

import java.util.UUID

data class UserModel (
    val id: UUID,
    val name: String,
    val profileImage: String?,
)