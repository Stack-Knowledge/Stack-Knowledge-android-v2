package com.stackknowledge.data.repository.auth

import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import com.stackknowledge.model.remote.response.auth.LoginResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun loginStudent(
        body: LoginRequest,
    ): Flow<LoginResponse>

    suspend fun loginTeacher(
        body: LoginRequest,
    ): Flow<LoginResponse>

    suspend fun saveToken(token: LoginResponse)

    suspend fun logout(): Flow<Unit>
}