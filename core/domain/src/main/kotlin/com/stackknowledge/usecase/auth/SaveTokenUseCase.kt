package com.stackknowledge.usecase.auth

import com.stackknowledge.repository.auth.AuthRepository
import remote.response.auth.LoginResponse
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(token: LoginResponse) = runCatching {
        authRepository.saveToken(token = token)
    }
}