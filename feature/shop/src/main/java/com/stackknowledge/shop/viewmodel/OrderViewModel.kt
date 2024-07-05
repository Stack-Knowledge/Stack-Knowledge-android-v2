package com.stackknowledge.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.shop.data.SelectedItemData
import com.stackknowledge.usecase.order.ChangeOrderStatusUseCase
import com.stackknowledge.usecase.order.OrderUseCase
import com.stackknowledge.usecase.order.ViewAllOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import remote.item.ItemModel
import remote.request.order.ChangeOrderStatusRequestModel
import remote.request.order.OrderRequestModel
import remote.request.order.OrdersModel
import remote.response.item.GetItemResponseModel
import remote.response.order.ViewAllOrderResponseModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderUseCase: OrderUseCase,
    private val viewAllOrderUseCase: ViewAllOrderUseCase,
    private val changeOrderStatusUseCase: ChangeOrderStatusUseCase,
) : ViewModel() {
    private val _orderResponse = MutableStateFlow<Event<Nothing>>(Event.Loading)
    internal val orderResponse = _orderResponse.asStateFlow()

    private val _viewAllOrderRequest =
        MutableStateFlow<Event<ViewAllOrderResponseModel>>(Event.Loading)
    internal val viewAllOrderRequest = _viewAllOrderRequest.asStateFlow()

    private val _changeOrderStatusRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    internal val changeOrderStatusRequest = _changeOrderStatusRequest.asStateFlow()

    val selectedItemList: MutableList<SelectedItemData> = mutableListOf()

    private val orderRequest = selectedItemList.map { selectedItemData ->
        OrderRequestModel(
            itemId = selectedItemData.id,
            count = selectedItemData.count,
        )
    }

    fun setOrderDataList(selectedItemList: List<GetItemResponseModel>) {
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

    fun order() = viewModelScope.launch {
        orderUseCase(
            body = orderRequest
        ).onSuccess {
            _orderResponse.value = Event.Success()
        }.onFailure {
            _orderResponse.value = it.errorHandling()
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