package com.stackkowledge.mission.viewmodel.uistate

import remote.response.mission.DetailMissionResponseModel

sealed interface DetailMissionUiState {
    object Loading : DetailMissionUiState
    data class Success(val body: DetailMissionResponseModel) : DetailMissionUiState
    data class Error(val exception: Throwable) : DetailMissionUiState
}