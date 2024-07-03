package remote.response.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class DetailMissionResponseModel(
    val title: String,
    val content: String,
    val timeLimit: Int,
)