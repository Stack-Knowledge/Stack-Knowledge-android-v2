package remote.request.solve

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SolveRequestModel (
    @Json(name = "solution") val solution: String,
)