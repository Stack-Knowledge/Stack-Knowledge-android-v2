package com.stackknowledge.model.remote.response.auth

import com.stackknowledge.model.remote.enumdatatype.Authority

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String,
    val authority: Authority
)