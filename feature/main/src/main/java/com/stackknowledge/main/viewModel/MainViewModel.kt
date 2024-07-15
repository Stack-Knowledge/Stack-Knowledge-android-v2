package com.stackknowledge.main.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.main.viewModel.uistate.GetMissionUiState
import com.stackknowledge.main.viewModel.uistate.GetRankingUiState
import com.stackknowledge.repository.auth.AuthRepository
import com.stackknowledge.usecase.auth.LogoutUseCase
import com.stackknowledge.usecase.mission.GetMissionUseCase
import com.stackknowledge.usecase.student.GetStudentPointRankingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMissionUseCase: GetMissionUseCase,
    private val getStudentPointRankingUseCase: GetStudentPointRankingUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val authRepository: AuthRepository
): ViewModel() {
    private val _getMissionUiState = MutableStateFlow<GetMissionUiState>(GetMissionUiState.Loading)
    internal val getMissionUiState = _getMissionUiState.asStateFlow()

    private val _getRankingUiState = MutableStateFlow<GetRankingUiState>(GetRankingUiState.Loading)
    internal val getRankingUiState = _getRankingUiState.asStateFlow()

    private val _logoutRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    internal val logoutRequest = _logoutRequest.asStateFlow()

    internal val role = authRepository.getRole()
    internal fun getMission() = viewModelScope.launch {
        getMissionUseCase()
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getMissionUiState.value = GetMissionUiState.Loading
                    is Result.Success -> _getMissionUiState.value = GetMissionUiState.Success(result.data)
                    is Result.Error -> _getMissionUiState.value = GetMissionUiState.Error(result.exception)
                }
            }
    }

    internal fun getRanking() = viewModelScope.launch {
        getStudentPointRankingUseCase()
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getRankingUiState.value = GetRankingUiState.Loading
                    is Result.Success -> _getRankingUiState.value = GetRankingUiState.Success(result.data)
                    is Result.Error -> _getRankingUiState.value = GetRankingUiState.Error(result.exception)
                }
            }
    }

    internal fun logout() = viewModelScope.launch {
        logoutUseCase()
            .onSuccess {
                it.catch { remoteError ->
                    _logoutRequest.value = remoteError.errorHandling()
                }.collect {
                    _logoutRequest.value = Event.Success()
                }
            }
            .onFailure {
                _logoutRequest.value = it.errorHandling()
            }
    }
}