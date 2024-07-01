package com.stackknowledge.usecase.auth

import com.stackknowledge.repository.auth.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = runCatching {
        authRepository.logout()
    }
}