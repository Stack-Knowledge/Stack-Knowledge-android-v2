package com.stackknowledge.main.viewModel.uistate

import remote.response.item.GetItemResponseModel
import remote.response.mission.MissionResponseModel

sealed interface GetMissionUiState {
    object Loading : GetMissionUiState
    data class Success(val getItemResponseModel: MissionResponseModel) : GetMissionUiState
    data class Error(val exception: Throwable) : GetMissionUiState
}