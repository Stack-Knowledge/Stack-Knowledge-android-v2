package com.stackknowledge.network.datasource.auth

import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import com.stackknowledge.model.remote.response.auth.LoginResponse
import kotlinx.coroutines.flow.Flow

interface AuthDataSource {
    suspend fun login(
        body: LoginRequest,
        role: String
    ): Flow<LoginResponse>

    suspend fun logout(): Flow<Unit>
}