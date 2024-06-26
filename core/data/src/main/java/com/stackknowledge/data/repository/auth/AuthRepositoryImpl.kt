package com.stackknowledge.data.repository.auth

import com.stackknowledge.datastore.LocalAuthDataSource
import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import com.stackknowledge.model.remote.response.auth.LoginResponse
import com.stackknowledge.network.datasource.auth.AuthDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val localDataSource: LocalAuthDataSource
): AuthRepository {
    override suspend fun loginStudent(body: LoginRequest): Flow<LoginResponse> {
        return authDataSource.loginStudent(
            body = body,
        )
    }

    override suspend fun loginTeacher(body: LoginRequest): Flow<LoginResponse> {
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

    override suspend fun logout(): Flow<Unit> {
        return authDataSource.logout()
    }
}