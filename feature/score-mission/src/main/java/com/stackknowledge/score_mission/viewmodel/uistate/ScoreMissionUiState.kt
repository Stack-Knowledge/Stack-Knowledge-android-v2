package com.stackknowledge.score_mission.viewmodel.uistate

import remote.request.user.ScoreRequestModel
import java.util.UUID

interface ScoreMissionUiState {
    object Loading: ScoreMissionUiState
    object Success: ScoreMissionUiState
    data class Error(val exception: Throwable): ScoreMissionUiState
}