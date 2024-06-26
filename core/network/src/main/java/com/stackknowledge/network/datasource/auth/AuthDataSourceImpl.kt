package com.stackknowledge.network.datasource.auth

import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import com.stackknowledge.model.remote.response.auth.LoginResponse
import com.stackknowledge.network.api.AuthAPI
import com.stackknowledge.network.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.Stack
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authAPI: AuthAPI
) : AuthDataSource {
    override suspend fun loginStudent(body: LoginRequest): Flow<LoginResponse> = flow {
        emit(
            StackKnowledgeApiHandler<LoginResponse>()
                .httpRequest {
                    authAPI.loginStudent(
                        body = body,
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun loginTeacher(body: LoginRequest): Flow<LoginResponse> = flow {
        emit(
            StackKnowledgeApiHandler<LoginResponse>()
                .httpRequest {
                    authAPI.loginTeacher(
                        body = body,
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun logout(): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { authAPI.logout() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}