package com.stackknowledge.ranking.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.stackknowledge.ranking.viewmodel.uistate.GetMyInformationUiState
import com.stackknowledge.ranking.viewmodel.uistate.GetRankingUiState
import com.stackknowledge.usecase.student.GetMyInformationUseCase
import com.stackknowledge.usecase.student.GetStudentPointRankingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val getStudentPointRankingUseCase: GetStudentPointRankingUseCase,
    private val getMyInformationUseCase: GetMyInformationUseCase,
): ViewModel() {
    private val _getRankingUiState = MutableStateFlow<GetRankingUiState>(GetRankingUiState.Loading)
    internal val getRankingUiState = _getRankingUiState.asStateFlow()

    private val _getMyInformationUiState = MutableStateFlow<GetMyInformationUiState>(
        GetMyInformationUiState.Loading)
    internal val getMyInformationUiState = _getMyInformationUiState.asStateFlow()
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

    internal fun getMyProfile() = viewModelScope.launch {
        getMyInformationUseCase()
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getMyInformationUiState.value = GetMyInformationUiState.Loading
                    is Result.Success -> _getMyInformationUiState.value = GetMyInformationUiState.Success(result.data)
                    is Result.Error -> _getMyInformationUiState.value = GetMyInformationUiState.Error(result.exception)
                }
            }
    }
}