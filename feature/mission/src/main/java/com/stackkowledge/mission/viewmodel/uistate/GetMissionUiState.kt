package com.stackkowledge.mission.viewmodel.uistate

import remote.response.mission.MissionResponseModel

sealed interface GetMissionUiState {
    object Loading : GetMissionUiState
    data class Success(val missionResponseModel: List<MissionResponseModel>) : GetMissionUiState
    data class Error(val exception: Throwable) : GetMissionUiState
}