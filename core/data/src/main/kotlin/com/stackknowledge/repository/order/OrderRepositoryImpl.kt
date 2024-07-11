package com.stackknowledge.repository.order

import com.stackknowledge.datasource.order.OrderDataSource
import com.stackknowledge.mapper.request.order.toDto
import com.stackknowledge.mapper.response.item.toModel
import com.stackknowledge.mapper.response.order.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import remote.request.order.ChangeOrderStatusRequestModel
import remote.request.order.OrderRequestModel
import remote.response.order.ViewAllOrderResponseModel
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val orderDataSource: OrderDataSource,
) : OrderRepository {
    override fun order(body: List<OrderRequestModel>): Flow<Unit> {
        return orderDataSource.order(body = body.map { it.toDto() })
    }

    override fun viewAllOrder(): Flow<List<ViewAllOrderResponseModel>> {
        return orderDataSource.viewAllOrder().map { list -> list.map { it.toModel() } }
    }

    override fun  changeOrderStatus(body: List<ChangeOrderStatusRequestModel>): Flow<Unit> {
        return orderDataSource.changeOrderStatus(body = body.map { it.toDto() })
    }
}