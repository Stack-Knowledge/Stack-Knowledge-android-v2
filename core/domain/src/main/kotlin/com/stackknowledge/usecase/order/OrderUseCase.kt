package com.stackknowledge.usecase.order

import com.stackknowledge.repository.order.OrderRepository
import remote.request.order.OrderRequestModel
import javax.inject.Inject

class OrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    operator fun invoke(body: List<OrderRequestModel>) = kotlin.runCatching {
        orderRepository.order(body = body)
    }
}