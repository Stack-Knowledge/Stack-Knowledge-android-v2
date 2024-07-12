package com.stackknowledge.mapper.response.auth

import com.stackknowledge.dto.response.auth.LoginResponse
import remote.response.auth.LoginResponseModel

fun LoginResponse.toModel(): LoginResponseModel = LoginResponseModel(
    accessToken = this.accessToken,
    refreshToken = this.refreshToken,
    expiredAt = this.expiredAt,
    authority = this.authority,
)