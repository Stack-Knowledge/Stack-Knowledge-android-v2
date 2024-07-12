package com.stackknowledge.login.viewmodel.uistate

import remote.response.auth.LoginResponseModel

sealed interface LoginUiState {
    object Loading : LoginUiState
    data class Success(val loginResponseModel: LoginResponseModel) : LoginUiState
    data class Error(val exception: Throwable) : LoginUiState
}