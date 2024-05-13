package com.stackknowledge.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stackknowledge.domain.auth.LogoutUseCase
import com.stackknowledge.domain.auth.SaveTokenUseCase
import com.stackknowledge.domain.auth.LoginUseCase
import com.stackknowledge.domain.auth.RequestAuthCodeUseCase
import com.stackknowledge.login.viewmodel.util.Event
import com.stackknowledge.login.viewmodel.util.errorHandling
import com.stackknowledge.model.remote.enumdatatype.Authority
import com.stackknowledge.model.remote.request.auth.LoginRequest
import com.stackknowledge.model.remote.response.auth.AuthCodeResponse
import com.stackknowledge.model.remote.response.auth.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
    private val requestAuthCodeUseCase: RequestAuthCodeUseCase
) : ViewModel() {
    private val _saveTokenRequest = MutableLiveData<Event<Nothing>>()
    val saveTokenRequest: LiveData<Event<Nothing>> get() = _saveTokenRequest

    private val _loginRequest = MutableLiveData<Event<LoginResponse>>()
    val loginRequest: LiveData<Event<LoginResponse>> get() = _loginRequest

    private val _getAuthorityResponse = MutableLiveData<Event<Authority>>()
    val getAuthority: LiveData<Event<Authority>> get() = _getAuthorityResponse

    private val _requestAuthCode = MutableLiveData<Event<AuthCodeResponse>>()
    val requestAuthCode: LiveData<Event<AuthCodeResponse>> get() = _requestAuthCode

    fun login(
        body: LoginRequest,
        role: Authority
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

    fun requestAuthCode(code: String) = viewModelScope.launch {
        requestAuthCodeUseCase(code = code)
            .onSuccess {
                it.catch { remoteError ->
                    _requestAuthCode.value = remoteError.errorHandling()
                }.collect { response ->
                    _requestAuthCode.value = Event.Success(data = response)
                }
            }.onFailure {
                _requestAuthCode.value = it.errorHandling()
            }
    }
}