package com.stackknowledge.repository.auth

import android.util.Log
import com.stackknowledge.datasource.auth.AuthDataSource
import com.stackknowledge.datastore.LocalAuthDataSource
import kotlinx.coroutines.flow.Flow
import remote.request.auth.LoginRequest
import remote.response.auth.LoginResponse
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