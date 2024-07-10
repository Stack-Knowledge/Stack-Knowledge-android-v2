package com.stackknowledge.repository.order

import kotlinx.coroutines.flow.Flow
import remote.request.order.ChangeOrderStatusRequestModel
import remote.request.order.OrderRequestModel
import remote.response.order.ViewAllOrderResponseModel

interface OrderRepository {
    fun order(body: List<OrderRequestModel>): Flow<Unit>

    fun viewAllOrder(): Flow<List<ViewAllOrderResponseModel>>

    fun changeOrderStatus(body: List<ChangeOrderStatusRequestModel>): Flow<Unit>
}