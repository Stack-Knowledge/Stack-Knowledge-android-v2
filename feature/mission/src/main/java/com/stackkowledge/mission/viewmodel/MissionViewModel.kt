package com.stackkowledge.mission.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.usecase.mission.CreateMissionUseCase
import com.stackknowledge.usecase.mission.DetailMissionUseCase
import com.stackknowledge.usecase.mission.GetMissionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
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
    private val _missionRequest = MutableStateFlow<Event<MissionResponseModel>>(Event.Loading)
    val missionRequest = _missionRequest.asStateFlow()

    private val _detailMissionRequest =
        MutableStateFlow<Event<DetailMissionResponseModel>>(Event.Loading)
    val detailMissionRequest = _detailMissionRequest.asStateFlow()

    private val _createMissionRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    val createMissionRequest = _createMissionRequest.asStateFlow()

    /*internal fun getMission() = viewModelScope.launch {
        getMissionUseCase()
            .onSuccess {
                it.catch { remoteError ->
                    _missionRequest.value = remoteError.errorHandling()
                }.collect { response ->
                    _missionRequest.value = Event.Success(data = response)
                }
            }
            .onFailure {
                _missionRequest.value = it.errorHandling()
            }
    }*/

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
            .onSuccess {
                _createMissionRequest.value = Event.Success()
            }
            .onFailure {
                _createMissionRequest.value = it.errorHandling()
            }
    }
}