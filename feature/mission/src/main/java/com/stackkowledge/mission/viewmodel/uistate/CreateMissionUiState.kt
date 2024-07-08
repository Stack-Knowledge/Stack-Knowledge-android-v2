package com.stackkowledge.mission.viewmodel.uistate

sealed interface CreateMissionUiState {
    object Loading : CreateMissionUiState
    object Success : CreateMissionUiState
    data class Error(val exception: Throwable) : CreateMissionUiState
}