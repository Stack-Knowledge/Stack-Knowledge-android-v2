package com.stackkowledge.mission.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.usecase.misson.CreateMissionUseCase
import com.stackknowledge.usecase.misson.DetailMissionUseCase
import com.stackknowledge.usecase.misson.GetMissionUseCase
import com.stackkowledge.mission.uistate.CreateMissionUiState
import com.stackkowledge.mission.uistate.GetMissionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import remote.request.mission.CreateMissionRequestModel
import remote.request.mission.DetailMissionRequestModel
import remote.response.mission.DetailMissionResponseModel
import remote.response.mission.MissionResponseModel
import javax.inject.Inject

@HiltViewModel
class MissionViewModel @Inject constructor(
    private val getMissionUseCase: GetMissionUseCase,
    private val detailMissionUseCase: DetailMissionUseCase,
    private val createMissionUseCase: CreateMissionUseCase,
) : ViewModel() {
    private val _missionUiState = MutableStateFlow<GetMissionUiState>(GetMissionUiState.Loading)
    val missionUiState = _missionUiState.asStateFlow()

    private val _detailMissionRequest =
        MutableStateFlow<Event<DetailMissionResponseModel>>(Event.Loading)
    val detailMissionRequest = _detailMissionRequest.asStateFlow()

    private val _createMissionUiState = MutableStateFlow<CreateMissionUiState>(CreateMissionUiState.Loading)
    val createMissionUiState = _createMissionUiState.asStateFlow()

    private val _title = mutableStateOf("")
    val title = _title

    private val _content = mutableStateOf("")
    val content = _content

    private val _minute = mutableIntStateOf(0)
    val minute = _minute

    private val _second = mutableIntStateOf(0)
    val second = _second

    private val _timeLimit = mutableIntStateOf(0)
    val timeLimit = _timeLimit

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

    internal fun detailMission(missionId: DetailMissionRequestModel) = viewModelScope.launch {
        detailMissionUseCase(missionId = missionId)
            .onSuccess {
                it.catch { remoteError ->
                    _detailMissionRequest.value = remoteError.errorHandling()
                }.collect { response ->
                    _detailMissionRequest.value = Event.Success(data = response)
                }
            }
            .onFailure {
                _detailMissionRequest.value = it.errorHandling()
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
}