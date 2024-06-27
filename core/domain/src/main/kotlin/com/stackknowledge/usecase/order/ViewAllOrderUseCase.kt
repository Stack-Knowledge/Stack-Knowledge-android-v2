package com.stackknowledge.usecase.order

import com.stackknowledge.repository.order.OrderRepository
import javax.inject.Inject

class ViewAllOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    operator fun invoke() = runCatching {
        orderRepository.viewAllOrder()
    }
}