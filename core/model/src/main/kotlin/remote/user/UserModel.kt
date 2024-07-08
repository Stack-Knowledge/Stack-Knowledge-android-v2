package remote.user

import java.util.UUID

data class UserModel (
    val userId: String,
    val name: String,
    val profileImage: String?,
)