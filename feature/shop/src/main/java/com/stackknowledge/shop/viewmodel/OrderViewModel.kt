package com.stackknowledge.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.usecase.order.ChangeOrderStatusUseCase
import com.stackknowledge.usecase.order.OrderUseCase
import com.stackknowledge.usecase.order.ViewAllOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import remote.request.order.ChangeOrderStatusRequestModel
import remote.request.order.OrderRequestModel
import remote.response.order.ViewAllOrderResponseModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderUseCase: OrderUseCase,
    private val viewAllOrderUseCase: ViewAllOrderUseCase,
    private val changeOrderStatusUseCase: ChangeOrderStatusUseCase,
) : ViewModel() {
    private val _orderRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    val orderRequest = _orderRequest.asStateFlow()

    private val _viewAllOrderRequest =
        MutableStateFlow<Event<ViewAllOrderResponseModel>>(Event.Loading)
    val viewAllOrderRequest = _viewAllOrderRequest.asStateFlow()

    private val _changeOrderStatusRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    val changeOrderStatusRequest = _changeOrderStatusRequest.asStateFlow()

    fun order(body: OrderRequestModel) = viewModelScope.launch {
        orderUseCase(body = body)
            .onSuccess {
                _orderRequest.value = Event.Success()
            }
            .onFailure {
                _orderRequest.value = it.errorHandling()
            }
    }

    fun viewAllOrder() = viewModelScope.launch {
        viewAllOrderUseCase()
            .onSuccess {
                it.catch { remoteError ->
                    _viewAllOrderRequest.value = remoteError.errorHandling()
                }.collect { response ->
                    _viewAllOrderRequest.value = Event.Success(data = response)
                }
            }
            .onFailure {
                _viewAllOrderRequest.value = it.errorHandling()
            }
    }

    fun changeOrderStatus(body: ChangeOrderStatusRequestModel) = viewModelScope.launch {
        changeOrderStatusUseCase(body = body)
            .onSuccess {
                _changeOrderStatusRequest.value = Event.Success()
            }
            .onFailure {
                _changeOrderStatusRequest.value = it.errorHandling()
            }
    }
}