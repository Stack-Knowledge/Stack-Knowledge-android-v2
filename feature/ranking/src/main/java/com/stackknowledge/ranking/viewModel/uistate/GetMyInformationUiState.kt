package com.stackknowledge.ranking.viewModel.uistate

import remote.response.student.GetMyInformationResponseModel
import remote.response.student.GetStudentPointRankingResponseModel

sealed interface GetMyInformationUiState {
    object Loading : GetMyInformationUiState
    data class Success(val getMyInformationResponseModel: GetMyInformationResponseModel) : GetMyInformationUiState
    data class Error(val exception: Throwable) : GetMyInformationUiState
}