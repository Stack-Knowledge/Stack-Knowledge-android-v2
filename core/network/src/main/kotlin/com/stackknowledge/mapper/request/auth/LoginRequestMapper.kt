package com.stackknowledge.mapper.request.auth

import com.stackknowledge.dto.request.auth.LoginRequest
import remote.request.auth.LoginRequestModel

fun LoginRequestModel.toDto(): LoginRequest = LoginRequest(
    code = this.code,
)