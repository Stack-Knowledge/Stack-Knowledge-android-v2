package remote.response.user

import java.util.UUID
data class DetailSolveMissionResponseModel(
    val solveId: UUID,
    val title: String,
    val solution: String,
)