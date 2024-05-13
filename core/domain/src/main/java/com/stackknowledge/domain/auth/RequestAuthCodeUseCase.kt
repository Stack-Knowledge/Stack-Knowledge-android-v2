package com.stackknowledge.domain.auth

import com.stackknowledge.data.repository.auth.AuthRepository
import javax.inject.Inject

class RequestAuthCodeUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(code: String) = runCatching {
        authRepository.requestAuthCode(code = code)
    }
}