package com.stackknowledge.resolve_mission.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.resolve_mission.viewmodel.uistate.DetailMissionUiState
import com.stackknowledge.resolve_mission.viewmodel.uistate.SolveMissionUiState
import com.stackknowledge.usecase.mission.DetailMissionUseCase
import com.stackknowledge.usecase.solve.SolveUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import remote.request.solve.SolveRequestModel
import remote.response.mission.DetailMissionResponseModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class SolveViewModel @Inject constructor(
    private val solveUseCase: SolveUseCase,
    private val detailMissionUseCase: DetailMissionUseCase,
): ViewModel() {
    private val _solveMissionUiState = MutableStateFlow<SolveMissionUiState>(SolveMissionUiState.Loading)
    internal val solveMissionUiState = _solveMissionUiState.asStateFlow()

    private val _detailMissionUiState =
        MutableStateFlow<DetailMissionUiState>(DetailMissionUiState.Loading)
    internal val detailMissionUiState = _detailMissionUiState.asStateFlow()

    private val _answer = mutableStateOf("")
    internal val answer = _answer

    private val _missionId = mutableStateOf("")
    internal val missionId = _missionId

    private val _timeLimit = mutableIntStateOf(0)
    internal val timeLimit = _timeLimit

    private val _minute = mutableIntStateOf(0)
    internal val minute = _minute

    private val _second = mutableIntStateOf(0)
    internal val second = _second

    internal fun solveMission(missionId: String, solution: SolveRequestModel) = viewModelScope.launch {
        solveUseCase(missionId = missionId, solution = solution)
            .asResult()
            .collectLatest {
                when(it) {
                    is Result.Loading -> _solveMissionUiState.value = SolveMissionUiState.Loading
                    is Result.Success -> _solveMissionUiState.value = SolveMissionUiState.Success
                    is Result.Error -> _solveMissionUiState.value = SolveMissionUiState.Error(it.exception)
                }
            }
    }

    internal fun detailMission(missionId: String) = viewModelScope.launch {
        detailMissionUseCase(missionId = missionId)
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _detailMissionUiState.value = DetailMissionUiState.Loading
                    is Result.Success -> _detailMissionUiState.value = DetailMissionUiState.Success(result.data)
                    is Result.Error -> _detailMissionUiState.value = DetailMissionUiState.Error(result.exception)
                }
            }
    }

    internal fun onAnswer(value: String) {
        _answer.value = value
    }

    fun onMissionId(value: String) {
        _missionId.value = value
    }

    fun onTimeLimit(value: Int) {
        _timeLimit.intValue = value
    }

    fun onMinute() {
        _minute.intValue = _timeLimit.intValue / 60
    }

    fun onSecond() {
        _second.intValue = _timeLimit.intValue % 60
    }
}