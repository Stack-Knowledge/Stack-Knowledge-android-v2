package com.stackknowledge.usecase.order

import com.stackknowledge.repository.order.OrderRepository
import remote.request.order.OrderRequestModel
import javax.inject.Inject

class OrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    operator fun invoke(body: OrderRequestModel) = runCatching {
        orderRepository.order(body = body)
    }
}