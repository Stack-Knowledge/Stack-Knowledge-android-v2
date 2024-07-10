package com.stackknowledge.main.viewModel.uistate

import remote.response.student.GetStudentPointRankingResponseModel

sealed interface GetRankingUiState {
    object Loading : GetRankingUiState
    data class Success(val getItemResponseModel: List<GetStudentPointRankingResponseModel>) : GetRankingUiState
    data class Error(val exception: Throwable) : GetRankingUiState
}