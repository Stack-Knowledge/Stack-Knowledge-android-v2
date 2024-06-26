package remote.request.mission

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.UUID

@JsonClass(generateAdapter = true)
data class DetailMissionRequestModel(
    @Json(name = "mission_id") val missionId: UUID,
)