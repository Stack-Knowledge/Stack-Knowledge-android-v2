package com.stackknowledge.usecase.auth

import com.stackknowledge.repository.auth.AuthRepository
import kotlinx.coroutines.flow.Flow
import remote.request.auth.LoginRequestModel
import remote.response.auth.LoginResponseModel
import javax.inject.Inject

class LoginTeacherUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(body: LoginRequestModel): Flow<LoginResponseModel> =
        authRepository.loginTeacher(body = body)

}