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
    override fun loginStudent(body: LoginRequestModel): Flow<LoginResponseModel> {
        return authDataSource.loginStudent(body = body.toDto()).map { it.toModel() }
    }

    override fun loginTeacher(body: LoginRequestModel): Flow<LoginResponseModel> {
        return authDataSource.loginTeacher(body = body.toDto()).map { it.toModel() }
    }

    override suspend fun saveToken(token: LoginResponseModel) {
        token.let {
            localDataSource.setAccessToken(it.accessToken)
            localDataSource.setAccessTime(it.expiredAt)
            localDataSource.setRefreshToken(it.refreshToken)
            localDataSource.setRefreshTime(it.expiredAt)
            localDataSource.setAuthorityInfo(it.authority.toString())
        }
    }

    override suspend fun deleteToken() {
        localDataSource.removeAccessToken()
        localDataSource.removeRefreshToken()
        localDataSource.removeAccessTime()
        localDataSource.removeRefreshTime()
    }

    override fun getRole(): Flow<String> {
        return localDataSource.getAuthorityInfo()
    }

    override fun logout(): Flow<Unit> {
        return authDataSource.logout()
    }
}