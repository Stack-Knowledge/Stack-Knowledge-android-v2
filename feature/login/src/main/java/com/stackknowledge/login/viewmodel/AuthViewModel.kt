package com.stackknowledge.login.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stackknowledge.domain.auth.LogoutUseCase
import com.stackknowledge.domain.auth.SaveTokenUseCase
import com.stackknowledge.domain.auth.LoginStudentUseCase
import com.stackknowledge.domain.auth.LoginTeacherUseCase
import com.stackknowledge.login.viewmodel.util.Event
import com.stackknowledge.login.viewmodel.util.errorHandling
import com.stackknowledge.model.remote.request.auth.LoginRequest
import com.stackknowledge.model.remote.response.auth.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginStudentUseCase: LoginStudentUseCase,
    private val loginTeacherUseCase: LoginTeacherUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
) : ViewModel() {
    private val _saveTokenRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    val saveTokenRequest = _saveTokenRequest.asStateFlow()

    private val _loginRequest = MutableStateFlow<Event<LoginResponse>>(Event.Loading)
    val loginRequest = _loginRequest.asStateFlow()

    private val _isStudent = MutableStateFlow(false)
    val isStudent = _isStudent.asStateFlow()

//    private val _isTeacher = MutableStateFlow(false)
//    val isTeacher = _isTeacher.asStateFlow()

    fun loginStudent(
        body: LoginRequest,
    ) = viewModelScope.launch {
        loginStudentUseCase(
            body = body,
        ).onSuccess {
            it.catch { remoteError ->
                _loginRequest.value = remoteError.errorHandling()
            }.collect { response ->
                _loginRequest.value = Event.Success(data = response)
            }
        }.onFailure {
            _loginRequest.value = it.errorHandling()
        }
    }

    fun loginTeacher(
        body: LoginRequest,
    ) = viewModelScope.launch {
        loginTeacherUseCase(
            body = body,
        ).onSuccess {
            it.catch { remoteError ->
                _loginRequest.value = remoteError.errorHandling()
            }.collect { response ->
                _loginRequest.value = Event.Success(data = response)
            }
        }.onFailure {
            _loginRequest.value = it.errorHandling()
        }
    }

    fun roleCheck(role: Boolean) {
        viewModelScope.launch {
            _isStudent.value = role
            Log.d("isStudent", isStudent.value.toString())
        }
    }

//    fun roleTeacher(role: Boolean) {
//        viewModelScope.launch {
//            _isUser.value = role
//        }
//    }
}