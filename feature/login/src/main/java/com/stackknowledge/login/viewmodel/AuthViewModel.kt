package com.stackknowledge.login.viewmodel

import android.app.Activity
import android.content.Context
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.stackknowledge.domain.auth.SaveTokenUseCase
import com.stackknowledge.domain.auth.LoginStudentUseCase
import com.stackknowledge.domain.auth.LoginTeacherUseCase
import com.stackknowledge.login.BuildConfig
import com.stackknowledge.login.viewmodel.util.Event
import com.stackknowledge.login.viewmodel.util.errorHandling
import com.stackknowledge.model.remote.request.auth.LoginRequest
import com.stackknowledge.model.remote.response.auth.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val loginStudentUseCase: LoginStudentUseCase,
    private val loginTeacherUseCase: LoginTeacherUseCase,
    private val saveTokenUseCase: SaveTokenUseCase,
) : ViewModel() {
    private val _saveTokenRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    val saveTokenRequest = _saveTokenRequest.asStateFlow()

    private val _loginResponse = MutableStateFlow<Event<LoginResponse>>(Event.Loading)
    val loginResponse = _loginResponse.asStateFlow()

    private val _googleAuthResult = MutableStateFlow<ActivityResult?>(null)
    val googleAuthResult = _googleAuthResult.asStateFlow()

    private val _signInError = MutableStateFlow<String?>(null)
    val signInError = _signInError.asStateFlow()

    private val googleSignInClient: GoogleSignInClient by lazy { getGoogleClient() }
    var isTeacher = mutableStateOf(false)
        private set

    var isStudent = mutableStateOf(false)
        private set

    private var googleAuthCode = mutableStateOf("")

    init {
        _googleAuthResult.value = null
    }

    internal fun loginStudent(
        body: LoginRequest,
    ) = viewModelScope.launch {
        loginStudentUseCase(
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

    internal fun googleSocialLogin() = viewModelScope.launch {
        googleSignInClient.signOut()
        val signInIntent = googleSignInClient.signInIntent
        _googleAuthResult.value = ActivityResult(Activity.RESULT_OK, signInIntent)
    }

    fun handleGoogleSignInResult(result: ActivityResult) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            account.serverAuthCode?.let { authCode ->
                setGoogleAuthCode(authCode)
            }
            _googleAuthResult.value = result
        } catch (e: ApiException) {
            _signInError.value = e.stackTraceToString()
        }
    }

    private fun getGoogleClient(): GoogleSignInClient {
        val googleSignInOption = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestScopes(Scope("${BuildConfig.SCOPE}"))
            .requestServerAuthCode("${BuildConfig.GOOGLE_CLIENT_ID}")
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(context, googleSignInOption)
    }

    private fun setGoogleAuthCode(authCode: String) {
        googleAuthCode.value = authCode
    }
}