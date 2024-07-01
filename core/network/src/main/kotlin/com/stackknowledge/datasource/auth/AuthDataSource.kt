package com.stackknowledge.datasource.auth

import kotlinx.coroutines.flow.Flow
import remote.request.auth.LoginRequest
import remote.response.auth.LoginResponse

interface AuthDataSource {
    fun loginStudent(body: LoginRequest): Flow<LoginResponse>
    fun loginTeacher(body: LoginRequest, ): Flow<LoginResponse>
    fun logout(): Flow<Unit>
}