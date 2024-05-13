package com.stackknowledge.domain.auth

import com.stackknowledge.data.repository.auth.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = runCatching {
        authRepository.logout()
    }
}