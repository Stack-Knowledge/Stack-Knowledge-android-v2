package com.stackknowledge.domain.auth

import com.stackknowledge.data.repository.auth.AuthRepository
import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        body: LoginRequest,
        role: Authority
    ) = runCatching {
        authRepository.login(
            body = body,
            role = role
        )
    }
}