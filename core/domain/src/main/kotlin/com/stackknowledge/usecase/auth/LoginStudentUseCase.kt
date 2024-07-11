package com.stackknowledge.usecase.auth

import com.stackknowledge.repository.auth.AuthRepository
import kotlinx.coroutines.flow.Flow
import remote.request.auth.LoginRequestModel
import remote.response.auth.LoginResponseModel
import javax.inject.Inject

class LoginStudentUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        body: LoginRequest,
    ) = runCatching {
        Log.e("useCase loginStudent", "loginStudent")
        authRepository.loginStudent(
            body = body,
        )
    }
}