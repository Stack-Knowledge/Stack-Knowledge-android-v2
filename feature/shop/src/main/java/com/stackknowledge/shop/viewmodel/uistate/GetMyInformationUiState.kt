package com.stackknowledge.shop.viewmodel.uistate

import remote.response.student.GetMyInformationResponseModel

sealed interface GetMyInformationUiState {
    object Loading : GetMyInformationUiState
    data class Success(val getMyInformationResponseModel: GetMyInformationResponseModel) :
        GetMyInformationUiState
    data class Error(val exception: Throwable) : GetMyInformationUiState
}