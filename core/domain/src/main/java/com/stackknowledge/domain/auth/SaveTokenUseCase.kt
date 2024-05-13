package com.stackknowledge.domain.auth

import com.stackknowledge.data.repository.auth.AuthRepository
import com.stackknowledge.model.remote.response.auth.LoginResponse
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(token: LoginResponse) = runCatching {
        authRepository.saveToken(token = token)
    }
}