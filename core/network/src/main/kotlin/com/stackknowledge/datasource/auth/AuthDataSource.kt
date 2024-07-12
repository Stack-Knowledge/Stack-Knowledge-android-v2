package com.stackknowledge.datasource.auth

import com.stackknowledge.dto.request.auth.LoginRequest
import com.stackknowledge.dto.response.auth.LoginResponse
import kotlinx.coroutines.flow.Flow

interface AuthDataSource {
    fun loginStudent(body: LoginRequest): Flow<LoginResponse>
    fun loginTeacher(body: LoginRequest): Flow<LoginResponse>
    fun logout(): Flow<Unit>
}