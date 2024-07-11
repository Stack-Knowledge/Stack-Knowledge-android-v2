package com.stackknowledge.login.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stackknowledge.usecase.auth.SaveTokenUseCase
import com.stackknowledge.usecase.auth.LoginStudentUseCase
import com.stackknowledge.usecase.auth.LoginTeacherUseCase
import com.stackknowledge.login.viewmodel.util.Event
import com.stackknowledge.login.viewmodel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
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
    val saveTokenRequest = _saveTokenRequest.asStateFlow()

    private val _loginResponse = MutableStateFlow<Event<LoginResponse>>(Event.Loading)
    val loginResponse = _loginResponse.asStateFlow()

    var isTeacher = mutableStateOf(false)
        private set

    var isStudent = mutableStateOf(false)
        private set

    var showLoginRoute = mutableStateOf(false)
        private set


    internal fun loginStudent(
        body: LoginRequest,
    ) = viewModelScope.launch {
        loginStudentUseCase(
            body = body,
        ).onSuccess {
            Log.e("viewModel loginStudent", "loginStudent")
            it.catch { remoteError ->
                _loginResponse.value = remoteError.errorHandling()
            }.collect { response ->
                _loginResponse.value = Event.Success(data = response)
            }
        }.onFailure {
            _loginResponse.value = it.errorHandling()
        }
    }

    internal fun loginTeacher(
        body: LoginRequest,
    ) = viewModelScope.launch {
        loginTeacherUseCase(
            body = body,
        ).onSuccess {
            it.catch { remoteError ->
                _loginResponse.value = remoteError.errorHandling()
            }.collect { response ->
                _loginResponse.value = Event.Success(data = response)
            }
        }.onFailure {
            _loginResponse.value = it.errorHandling()
        }
    }

    internal fun saveToken(
        token: LoginResponse,
    ) = viewModelScope.launch {
        saveTokenUseCase(
            token = token
        ).onSuccess {
            _saveTokenRequest.value = Event.Success()
        }.onFailure {
            _saveTokenRequest.value = it.errorHandling()
        }
    }
}