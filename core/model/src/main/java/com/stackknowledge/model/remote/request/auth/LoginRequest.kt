package com.stackknowledge.model.remote.request.auth

import com.stackknowledge.model.remote.enumdatatype.Authority

data class LoginRequest(
    val code: String
)