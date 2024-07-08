package com.stackknowledge.datasource.order

import com.stackknowledge.api.OrderAPI
import com.stackknowledge.dto.request.order.ChangeOrderStatusRequest
import com.stackknowledge.dto.request.order.OrderRequest
import com.stackknowledge.dto.response.order.ViewAllOrderResponse
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import remote.request.order.OrderRequestModel
import javax.inject.Inject

class OrderDataSourceImpl @Inject constructor(
    private val orderAPI: OrderAPI
): OrderDataSource {
    override fun order(body: List<OrderRequest>): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { orderAPI.order(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun viewAllOrder(): Flow<List<ViewAllOrderResponse>> = flow {
        emit(
            StackKnowledgeApiHandler<List<ViewAllOrderResponse>>()
                .httpRequest { orderAPI.viewAllOrder() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun changeOrderStatus(body: ChangeOrderStatusRequest): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { orderAPI.changeOrderStatus(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}