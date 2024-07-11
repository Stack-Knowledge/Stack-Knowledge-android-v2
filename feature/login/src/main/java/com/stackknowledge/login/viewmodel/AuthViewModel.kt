package com.stackknowledge.login.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.login.viewmodel.uistate.LoginUiState
import com.stackknowledge.usecase.auth.SaveTokenUseCase
import com.stackknowledge.usecase.auth.LoginStudentUseCase
import com.stackknowledge.usecase.auth.LoginTeacherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import remote.request.auth.LoginRequestModel
import remote.response.auth.LoginResponseModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginStudentUseCase: LoginStudentUseCase,
    private val loginTeacherUseCase: LoginTeacherUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
) : ViewModel() {
    private val _saveTokenRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    internal val saveTokenRequest = _saveTokenRequest.asStateFlow()

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Loading)
    internal val loginUiState = _loginUiState.asStateFlow()

    var isTeacher = mutableStateOf(false)
        private set

    var isStudent = mutableStateOf(false)
        private set

    fun loginStudent(body: LoginRequestModel) = viewModelScope.launch {
        loginStudentUseCase(body = body)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _loginUiState.value = LoginUiState.Loading
                    is Result.Success -> _loginUiState.value = LoginUiState.Success(result.data)
                    is Result.Error -> _loginUiState.value = LoginUiState.Error(result.exception)
                }
            }
    }

    fun loginTeacher(body: LoginRequestModel) = viewModelScope.launch {
        loginTeacherUseCase(body = body)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _loginUiState.value = LoginUiState.Loading
                    is Result.Success -> _loginUiState.value = LoginUiState.Success(result.data)
                    is Result.Error -> _loginUiState.value = LoginUiState.Error(result.exception)
                }

            }
    }

    internal fun saveToken(token: LoginResponseModel) = viewModelScope.launch {
        saveTokenUseCase(
            token = token
        ).onSuccess {
            _saveTokenRequest.value = Event.Success()
        }.onFailure {
            _saveTokenRequest.value = it.errorHandling()
        }
    }
}