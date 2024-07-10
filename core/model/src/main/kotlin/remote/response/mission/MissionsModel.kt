package remote.response.mission

<<<<<<< HEAD
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import enumdata.MissionStatus
=======
import enumdatatype.MissionStatus
>>>>>>> 7968c9bc41ecc66967c282ccfb3222e458eb598b
import remote.user.UserModel
import java.util.UUID

data class MissionsModel(
    val id: UUID,
    val title: String,
    val point: Int,
    val missionStatus: MissionStatus,
    val user: UserModel,
)
