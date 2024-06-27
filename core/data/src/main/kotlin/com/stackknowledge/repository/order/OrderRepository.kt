package com.stackknowledge.repository.order

import kotlinx.coroutines.flow.Flow
import remote.request.order.ChangeOrderStatusRequestModel
import remote.request.order.OrderRequestModel
import remote.response.order.ViewAllOrderResponseModel

interface OrderRepository {
    fun order(body: OrderRequestModel): Flow<Unit>

    fun viewAllOrder(): Flow<ViewAllOrderResponseModel>

    fun changeOrderStatus(body: ChangeOrderStatusRequestModel): Flow<Unit>
}