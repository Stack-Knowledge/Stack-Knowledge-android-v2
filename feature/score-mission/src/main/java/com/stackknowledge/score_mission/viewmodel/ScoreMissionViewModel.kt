package com.stackknowledge.score_mission.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.stackknowledge.score_mission.viewmodel.uistate.DetailScoreMissionUiState
import com.stackknowledge.score_mission.viewmodel.uistate.GetScoreMissionListUiState
import com.stackknowledge.score_mission.viewmodel.uistate.ScoreMissionUiState
import com.stackknowledge.usecase.user.DetailScoreMissionUseCase
import com.stackknowledge.usecase.user.GetScoreMissionListUseCase
import com.stackknowledge.usecase.user.ScoreMissionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import remote.request.user.ScoreRequestModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ScoreMissionViewModel @Inject constructor(
    private val getScoreMissionUseCase: GetScoreMissionListUseCase,
    private val detailScoreMissionUseCase: DetailScoreMissionUseCase,
    private val scoreMissionUseCase: ScoreMissionUseCase,
) : ViewModel() {
    private val _getScoreMissionUiState =
        MutableStateFlow<GetScoreMissionListUiState>(GetScoreMissionListUiState.Loading)
    val getScoreMissionListUiState = _getScoreMissionUiState.asStateFlow()

    private val _detailScoreMissionUiState =
        MutableStateFlow<DetailScoreMissionUiState>(DetailScoreMissionUiState.Loading)
    val detailScoreMissionUiState = _detailScoreMissionUiState.asStateFlow()

    private val _scoreMissionUiState =
        MutableStateFlow<ScoreMissionUiState>(ScoreMissionUiState.Loading)
    val scoreMissionUiState = _scoreMissionUiState.asStateFlow()

    internal fun getScoreMissionList() = viewModelScope.launch {
        getScoreMissionUseCase()
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getScoreMissionUiState.value = GetScoreMissionListUiState.Loading
                    is Result.Success -> _getScoreMissionUiState.value = GetScoreMissionListUiState.Success(result.data)
                    is Result.Error -> _getScoreMissionUiState.value = GetScoreMissionListUiState.Error(result.exception)
                }
            }
    }

    internal fun detailScoreMission(solveId: UUID) = viewModelScope.launch {
        detailScoreMissionUseCase(solveId = solveId)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _detailScoreMissionUiState.value =
                        DetailScoreMissionUiState.Loading

                    is Result.Success -> _detailScoreMissionUiState.value =
                        DetailScoreMissionUiState.Success(result.data)

                    is Result.Error -> _detailScoreMissionUiState.value =
                        DetailScoreMissionUiState.Error(result.exception)
                }
            }
    }

    internal fun scoreMission(
        solveId: UUID,
        body: ScoreRequestModel
    ) = viewModelScope.launch {
        scoreMissionUseCase(
            solveId = solveId,
            body = body
        )
            .asResult()
            .collectLatest {
                when(it) {
                    is Result.Loading -> _scoreMissionUiState.value = ScoreMissionUiState.Loading
                    is Result.Success -> _scoreMissionUiState.value = ScoreMissionUiState.Success
                    is Result.Error -> _scoreMissionUiState.value = ScoreMissionUiState.Error(it.exception)
                }
            }
    }
}