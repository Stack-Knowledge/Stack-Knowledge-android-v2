package com.stackkowledge.mission.viewmodel.uistate

sealed interface SolveMissionUiState {
    object Loading : SolveMissionUiState
    object Success : SolveMissionUiState
    data class Error(val exception: Throwable) : SolveMissionUiState
}