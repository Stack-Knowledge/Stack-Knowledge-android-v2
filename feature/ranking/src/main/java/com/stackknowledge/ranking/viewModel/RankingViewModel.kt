package com.stackknowledge.ranking.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.stackknowledge.ranking.viewModel.uistate.GetRankingUiState
import com.stackknowledge.usecase.mission.GetMissionUseCase
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
): ViewModel() {
    private val _getRankingUiState = MutableStateFlow<GetRankingUiState>(GetRankingUiState.Loading)
    internal val getRankingUiState = _getRankingUiState.asStateFlow()
    internal fun getRanking() = viewModelScope.launch {
        getStudentPointRankingUseCase()
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> {
                        Log.d("testt","load")
                        _getRankingUiState.value = GetRankingUiState.Loading
                    }
                    is Result.Success -> {
                        Log.d("testt","suc")
                        _getRankingUiState.value = GetRankingUiState.Success(result.data)
                    }
                    is Result.Error -> {
                        Log.d("testt",result.exception.toString())
                        _getRankingUiState.value = GetRankingUiState.Error(result.exception)
                    }
                }
            }
    }
}