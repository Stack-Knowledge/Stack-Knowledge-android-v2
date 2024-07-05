package remote.response.user

import remote.user.UserModel
import java.util.UUID

data class GetSolveMissionResponseModel(
    val response: List<GetSolveMissionListModel>
)
