package com.stackknowledge.score_mission.viewmodel.uistate

import remote.response.user.GetSolveMissionResponseModel
import java.util.UUID

sealed interface GetScoreMissionListUiState {
    object Loading: GetScoreMissionListUiState
    data class Success(val getSolveMissionResponseModel: List<GetSolveMissionResponseModel>): GetScoreMissionListUiState
    data class Error(val exception: Throwable): GetScoreMissionListUiState
}