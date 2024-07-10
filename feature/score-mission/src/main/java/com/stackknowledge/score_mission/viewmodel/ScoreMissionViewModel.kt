package com.stackknowledge.score_mission.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.score_mission.viewmodel.uistate.DetailScoreMissionUiState
import com.stackknowledge.score_mission.viewmodel.uistate.GetScoreMissionListUiState
import com.stackknowledge.score_mission.viewmodel.uistate.ScoreMissionUiState
import com.stackknowledge.usecase.user.DetailScoreMissionUseCase
import com.stackknowledge.usecase.user.GetScoreMissionListUseCase
import com.stackknowledge.usecase.user.ScoreMissionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
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
    internal val getScoreMissionListUiState = _getScoreMissionUiState.asStateFlow()

    private val _detailScoreMissionUiState =
        MutableStateFlow<DetailScoreMissionUiState>(DetailScoreMissionUiState.Loading)
    internal val detailScoreMissionUiState = _detailScoreMissionUiState.asStateFlow()

    private val _scoreMissionUiState =
        MutableStateFlow<Event<Nothing>>(Event.Loading)
    internal val scoreMissionUiState = _scoreMissionUiState.asStateFlow()

    private var _solveId = mutableStateOf("")
    internal val solveId = _solveId

    private var _solveStatus = mutableStateOf("CORRECT_ANSWER")
    internal val solveStatus = _solveStatus

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

    internal fun detailScoreMission(solveId: String) = viewModelScope.launch {
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
        solveId: String,
        body: ScoreRequestModel
    ) = viewModelScope.launch {
        scoreMissionUseCase(
            solveId = solveId,
            body = body
        ).onSuccess {
            it.catch { remoteError ->
                _scoreMissionUiState.value = remoteError.errorHandling()
            }.collect {
                _scoreMissionUiState.value = Event.Success()
            }
        }.onFailure {
            _scoreMissionUiState.value = it.errorHandling()
        }
    }

    internal fun onSolveId(value: String) {
        _solveId.value = value
    }

    internal fun onSolveStatus(value: String) {
        _solveStatus.value = value
        Log.e("testt", solveStatus.value)
    }
}