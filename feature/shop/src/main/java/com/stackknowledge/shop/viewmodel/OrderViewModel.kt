package com.stackknowledge.shop.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.shop.data.SelectedItemData
import com.stackknowledge.shop.viewmodel.uistate.GetOrderListUiState
import com.stackknowledge.usecase.order.ChangeOrderStatusUseCase
import com.stackknowledge.usecase.order.OrderUseCase
import com.stackknowledge.usecase.order.ViewAllOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import remote.request.order.ChangeOrderStatusRequestModel
import remote.request.order.OrderRequestModel
import remote.response.item.GetItemResponseModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderUseCase: OrderUseCase,
    private val viewAllOrderUseCase: ViewAllOrderUseCase,
    private val changeOrderStatusUseCase: ChangeOrderStatusUseCase,
) : ViewModel() {
    private val _orderResponse = MutableStateFlow<Event<Nothing>>(Event.Loading)
    internal val orderResponse = _orderResponse.asStateFlow()

    private val _getOrderListUiState = MutableStateFlow<GetOrderListUiState>(GetOrderListUiState.Loading)
    internal val getOrderListUiState = _getOrderListUiState.asStateFlow()

    private val _changeOrderStatusRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    internal val changeOrderStatusRequest = _changeOrderStatusRequest.asStateFlow()

    val selectedItemList: MutableList<SelectedItemData> = mutableListOf()

    private fun convertToOrderRequest(): List<OrderRequestModel> {
        return selectedItemList.map { selectedItemData ->
            OrderRequestModel(
                itemId = selectedItemData.id,
                count = selectedItemData.count,
            )
        }
    }

    internal fun setOrderDataList(selectedItemList: List<GetItemResponseModel>) {
        this.selectedItemList.clear()
        selectedItemList.forEach { itemModel ->
            val selectedItem = SelectedItemData(
                id = itemModel.id,
                name = itemModel.name,
                count = 1,
                price = itemModel.price,
            )
            this.selectedItemList.add(selectedItem)
        }
    }

    internal fun order() = viewModelScope.launch {
        val orderRequest = convertToOrderRequest()

        orderUseCase(
            body = orderRequest
        ).onSuccess {
            it.catch { remoteError ->
                _orderResponse.value = remoteError.errorHandling()
                Log.e("Order remoteError", remoteError.toString())
            }.collect {
                _orderResponse.value = Event.Success()
                Log.e("Order Success Block", "Order Success Block")
            }
        }.onFailure { error ->
            _orderResponse.value = error.errorHandling()
            Log.e("Order Failure Block", error.toString())
        }
    }

    internal fun viewAllOrder() = viewModelScope.launch {
        viewAllOrderUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getOrderListUiState.value = GetOrderListUiState.Loading
                    is Result.Success -> _getOrderListUiState.value = GetOrderListUiState.Success(result.data)
                    is Result.Error -> _getOrderListUiState.value = GetOrderListUiState.Error(result.exception)
                }
            }
    }

    internal fun changeOrderStatus(body: ChangeOrderStatusRequestModel) = viewModelScope.launch {
        changeOrderStatusUseCase(body = body)
            .onSuccess {
                _changeOrderStatusRequest.value = Event.Success()
            }
            .onFailure {
                _changeOrderStatusRequest.value = it.errorHandling()
            }
    }
}