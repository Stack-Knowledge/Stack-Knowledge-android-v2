package remote.response.auth

import enumdata.Authority

data class LoginResponseModel(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String,
    val authority: Authority,
)