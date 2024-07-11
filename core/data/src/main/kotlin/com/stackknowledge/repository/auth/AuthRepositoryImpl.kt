package com.stackknowledge.repository.auth

import com.stackknowledge.datasource.auth.AuthDataSource
import com.stackknowledge.datastore.LocalAuthDataSource
import com.stackknowledge.mapper.request.auth.toDto
import com.stackknowledge.mapper.response.auth.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import remote.request.auth.LoginRequestModel
import remote.response.auth.LoginResponseModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val localDataSource: LocalAuthDataSource
): AuthRepository {
    override fun loginStudent(body: LoginRequest): Flow<LoginResponse> {
        Log.e("repository loginStudent", "loginStudent")
        return authDataSource.loginStudent(
            body = body,
        )
    }

    override fun loginTeacher(body: LoginRequest): Flow<LoginResponse> {
        return authDataSource.loginTeacher(
            body = body,
        )
    }

    override suspend fun saveToken(token: LoginResponse) {
        token.let {
            localDataSource.setAccessToken(it.accessToken)
            localDataSource.setAccessTime(it.expiredAt)
            localDataSource.setRefreshToken(it.refreshToken)
            localDataSource.setRefreshTime(it.expiredAt)
            localDataSource.setAuthorityInfo(it.authority.toString())
        }
    }

    override fun logout(): Flow<Unit> {
        return authDataSource.logout()
    }
}