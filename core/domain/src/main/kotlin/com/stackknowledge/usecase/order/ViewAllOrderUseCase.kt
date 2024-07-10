package com.stackknowledge.usecase.order

import com.stackknowledge.repository.order.OrderRepository
import kotlinx.coroutines.flow.Flow
import remote.response.order.ViewAllOrderResponseModel
import javax.inject.Inject

class ViewAllOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    operator fun invoke(): Flow<List<ViewAllOrderResponseModel>> =
        orderRepository.viewAllOrder()
}