package com.stackknowledge.usecase.auth

import com.stackknowledge.repository.auth.AuthRepository
import kotlinx.coroutines.flow.Flow
import remote.request.auth.LoginRequestModel
import remote.response.auth.LoginResponseModel
import javax.inject.Inject

class LoginTeacherUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        body: LoginRequest,
    ) = runCatching {
        authRepository.loginTeacher(
            body = body,
        )
    }
}