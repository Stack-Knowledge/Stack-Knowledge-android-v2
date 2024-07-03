package remote.request.mission

data class CreateMissionRequestModel(
    val title: String,
    val content: String,
    val timeLimit: Int,
)