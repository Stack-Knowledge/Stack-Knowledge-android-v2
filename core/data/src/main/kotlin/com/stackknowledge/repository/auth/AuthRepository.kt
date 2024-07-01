package com.stackknowledge.repository.auth

import kotlinx.coroutines.flow.Flow
import remote.request.auth.LoginRequest
import remote.response.auth.LoginResponse

interface AuthRepository {
    fun loginStudent(
        body: LoginRequest,
    ): Flow<LoginResponse>

    fun loginTeacher(
        body: LoginRequest,
    ): Flow<LoginResponse>

    suspend fun saveToken(token: LoginResponse)

    fun logout(): Flow<Unit>
}