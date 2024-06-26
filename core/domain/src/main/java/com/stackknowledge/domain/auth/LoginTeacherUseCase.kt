package com.stackknowledge.domain.auth

import com.stackknowledge.data.repository.auth.AuthRepository
import com.stackknowledge.model.remote.request.auth.LoginRequest
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