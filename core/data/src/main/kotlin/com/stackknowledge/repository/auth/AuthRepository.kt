package com.stackknowledge.repository.auth

import kotlinx.coroutines.flow.Flow
import remote.request.auth.LoginRequestModel
import remote.response.auth.LoginResponseModel

interface AuthRepository {
    fun loginStudent(body: LoginRequestModel): Flow<LoginResponseModel>

    fun loginTeacher(body: LoginRequestModel): Flow<LoginResponseModel>

    suspend fun saveToken(token: LoginResponseModel)

    fun getRole(): Flow<String>

    fun logout(): Flow<Unit>
}