package com.stackknowledge.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stackknowledge.domain.auth.LogoutUseCase
import com.stackknowledge.domain.auth.SaveTokenUseCase
import com.stackknowledge.domain.auth.LoginUseCase
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
    private val loginUseCase: LoginUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
) : ViewModel() {
    private val _saveTokenRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    val saveTokenRequest = _saveTokenRequest.asStateFlow()

    private val _loginRequest = MutableStateFlow<Event<LoginResponse>>(Event.Loading)
    val loginRequest = _loginRequest.asStateFlow()

    fun login(
        body: LoginRequest,
        role: String
    ) = viewModelScope.launch {
        loginUseCase(
            body = body,
            role = role
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
}