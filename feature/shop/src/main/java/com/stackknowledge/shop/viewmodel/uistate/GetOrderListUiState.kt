package com.stackknowledge.shop.viewmodel.uistate

import remote.response.order.ViewAllOrderResponseModel

sealed interface GetOrderListUiState {
object Loading : GetOrderListUiState
    data class Success(val viewOrderListResponseModel: List<ViewAllOrderResponseModel>) : GetOrderListUiState
    data class Error(val exception: Throwable) : GetOrderListUiState
}