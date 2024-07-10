package remote.response.mission

<<<<<<< HEAD
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
=======
import enumdatatype.MissionStatus
import remote.user.UserModel
import java.util.UUID
>>>>>>> 7968c9bc41ecc66967c282ccfb3222e458eb598b

data class MissionResponseModel(
    val id: String,
    val title: String,
    val point: Int,
    val missionStatus: String,
    val user: UserModel,
)