package remote.request.student

import okhttp3.MultipartBody

data class UploadProfileImageRequest(
    val image: MultipartBody.Part
)