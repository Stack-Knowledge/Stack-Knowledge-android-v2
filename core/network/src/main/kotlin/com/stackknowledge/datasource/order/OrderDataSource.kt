package com.stackknowledge.datasource.order

import com.stackknowledge.dto.request.order.ChangeOrderStatusRequest
import com.stackknowledge.dto.request.order.OrderRequest
import com.stackknowledge.dto.response.order.ViewAllOrderResponse
import kotlinx.coroutines.flow.Flow
import remote.request.order.ChangeOrderStatusRequestModel
import remote.request.order.OrderRequestModel
import remote.response.order.ViewAllOrderResponseModel

interface OrderDataSource {
    fun order(body: List<OrderRequest>): Flow<Unit>

    fun viewAllOrder(): Flow<List<ViewAllOrderResponse>>

    fun changeOrderStatus(body: ChangeOrderStatusRequest): Flow<Unit>
}