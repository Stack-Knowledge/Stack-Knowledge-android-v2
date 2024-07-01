package com.stackknowledge.datasource.auth

import android.util.Log
import com.stackknowledge.api.AuthAPI
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import remote.request.auth.LoginRequest
import remote.response.auth.LoginResponse
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authAPI: AuthAPI
) : AuthDataSource {
    override fun loginStudent(body: LoginRequest): Flow<LoginResponse> = flow {
        Log.e("dataSource loginStudent", "loginStudent")
        emit(
            StackKnowledgeApiHandler<LoginResponse>()
                .httpRequest {
                    authAPI.loginStudent(
                        body = body,
                    )
                }
                .sendRequest()
        )
        Log.e("dataSource loginStudent", "loginStudent")
    }.flowOn(Dispatchers.IO)

    override fun loginTeacher(body: LoginRequest): Flow<LoginResponse> = flow {
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

    override fun logout(): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { authAPI.logout() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}