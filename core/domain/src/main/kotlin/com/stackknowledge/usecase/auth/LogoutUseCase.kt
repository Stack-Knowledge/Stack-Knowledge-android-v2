package com.stackknowledge.usecase.auth

import com.stackknowledge.repository.auth.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = kotlin.runCatching {
        authRepository.logout()
    }
}