package com.stackknowledge.score_mission.viewmodel.uistate

import remote.response.user.DetailSolveMissionResponseModel
import java.util.UUID

sealed interface DetailScoreMissionUiState {
    object Loading: DetailScoreMissionUiState
    data class Success(val detailSolveMissionResponseModel: DetailSolveMissionResponseModel): DetailScoreMissionUiState
    data class Error(val exception: Throwable): DetailScoreMissionUiState
}