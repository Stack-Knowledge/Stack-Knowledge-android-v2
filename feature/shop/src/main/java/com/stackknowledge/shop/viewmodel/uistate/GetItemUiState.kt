package com.stackknowledge.shop.viewmodel.uistate

import remote.response.item.GetItemResponseModel

sealed interface GetItemUiState {
    object Loading : GetItemUiState
    data class Success(val getItemResponseModel: List<GetItemResponseModel>) : GetItemUiState
    data class Error(val exception: Throwable) : GetItemUiState
}