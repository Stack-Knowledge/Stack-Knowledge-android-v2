package remote.response.user

import java.util.UUID
data class DetailSolveMissionResponseModel(
    val solveId: String,
    val title: String,
    val solution: String,
)