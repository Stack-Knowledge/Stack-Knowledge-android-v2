package com.stackknowledge.usecase.auth

import com.stackknowledge.repository.auth.AuthRepository
import remote.request.auth.LoginRequest
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