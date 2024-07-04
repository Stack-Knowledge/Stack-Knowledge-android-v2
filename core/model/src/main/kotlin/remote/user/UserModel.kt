package remote.user

import java.util.UUID

data class UserModel (
    val id: String,
    val name: String,
    val profileImage: String?,
)