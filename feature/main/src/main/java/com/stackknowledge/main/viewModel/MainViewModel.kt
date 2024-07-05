package com.stackknowledge.main.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.stackknowledge.main.viewModel.uistate.GetMissionUiState
import com.stackknowledge.main.viewModel.uistate.GetRankingUiState
import com.stackknowledge.usecase.mission.GetMissionUseCase
import com.stackknowledge.usecase.student.GetStudentPointRankingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMissionUseCase: GetMissionUseCase,
    private val getStudentPointRankingUseCase: GetStudentPointRankingUseCase,
): ViewModel() {
    private val _getMissionUiState = MutableStateFlow<GetMissionUiState>(GetMissionUiState.Loading)
    internal val getMissionUiState = _getMissionUiState.asStateFlow()

    private val _getRankingUiState = MutableStateFlow<GetRankingUiState>(GetRankingUiState.Loading)
    internal val getRankingUiState = _getRankingUiState.asStateFlow()
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
}