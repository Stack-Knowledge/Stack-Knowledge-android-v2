package com.stackkowledge.mission.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.usecase.mission.CreateMissionUseCase
import com.stackknowledge.usecase.mission.DetailMissionUseCase
import com.stackknowledge.usecase.mission.GetMissionUseCase
import com.stackknowledge.usecase.solve.SolveUseCase
import com.stackkowledge.mission.viewmodel.uistate.CreateMissionUiState
import com.stackkowledge.mission.viewmodel.uistate.GetMissionUiState
import com.stackkowledge.mission.viewmodel.uistate.DetailMissionUiState
import com.stackkowledge.mission.viewmodel.uistate.SolveMissionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import remote.request.mission.CreateMissionRequestModel
import remote.request.solve.SolveRequestModel
import remote.response.mission.DetailMissionResponseModel
import javax.inject.Inject

@HiltViewModel
class MissionViewModel @Inject constructor(
    private val getMissionUseCase: GetMissionUseCase,
    private val createMissionUseCase: CreateMissionUseCase,
    private val detailMissionUseCase: DetailMissionUseCase,
) : ViewModel() {
    private val _missionUiState = MutableStateFlow<GetMissionUiState>(GetMissionUiState.Loading)
    internal val missionUiState = _missionUiState.asStateFlow()

    private val _createMissionUiState = MutableStateFlow<CreateMissionUiState>(CreateMissionUiState.Loading)
    internal val createMissionUiState = _createMissionUiState.asStateFlow()

    private val _detailMissionUiState =
        MutableStateFlow<DetailMissionUiState>(DetailMissionUiState.Loading)
    internal val detailMissionUiState = _detailMissionUiState.asStateFlow()

    private val _title = mutableStateOf("")
    internal val title = _title

    private val _content = mutableStateOf("")
    internal val content = _content

    private val _minute = mutableIntStateOf(0)
    internal val minute = _minute

    private val _second = mutableIntStateOf(0)
    internal val second = _second

    private val _timeLimit = mutableIntStateOf(0)
    internal val timeLimit = _timeLimit

    private val _answer = mutableStateOf("")
    internal val answer = _answer

    private val _missionId = mutableStateOf("")
    internal val missionId = _missionId

    internal fun getMission() = viewModelScope.launch {
        getMissionUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _missionUiState.value = GetMissionUiState.Loading
                    is Result.Success -> _missionUiState.value = GetMissionUiState.Success(result.data)
                    is Result.Error -> _missionUiState.value = GetMissionUiState.Error(result.exception)
                }
            }
    }

    internal fun createMission(body: CreateMissionRequestModel) = viewModelScope.launch {
        createMissionUseCase(body = body)
            .asResult()
            .collectLatest {
                when(it) {
                    is Result.Loading -> _createMissionUiState.value = CreateMissionUiState.Loading
                    is Result.Success -> _createMissionUiState.value = CreateMissionUiState.Success
                    is Result.Error -> _createMissionUiState.value = CreateMissionUiState.Error(it.exception)
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

    internal fun onTitle(value: String) {
        _title.value = value
    }

    internal fun onContent(value: String) {
        _content.value = value
    }

    internal fun onMinute(value: Int) {
        _minute.intValue = value
    }

    internal fun onSecond(value: Int) {
        _second.intValue = value
    }

    internal fun onTimeLimit() {
        _timeLimit.intValue = (minute.intValue * 60) + second.intValue
    }

    internal fun onAnswer(value: String) {
        _answer.value = value
    }

    internal fun onMissionId(value: String) {
        _missionId.value = value
    }
}