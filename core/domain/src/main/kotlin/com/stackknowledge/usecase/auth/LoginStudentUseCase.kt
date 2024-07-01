package com.stackknowledge.usecase.auth

import android.util.Log
import com.stackknowledge.repository.auth.AuthRepository
import remote.request.auth.LoginRequest
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