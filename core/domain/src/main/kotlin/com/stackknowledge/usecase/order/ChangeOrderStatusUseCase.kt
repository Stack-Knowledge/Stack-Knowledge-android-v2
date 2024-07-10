package com.stackknowledge.usecase.order

import com.stackknowledge.repository.order.OrderRepository
import remote.request.order.ChangeOrderStatusRequestModel
import javax.inject.Inject

class ChangeOrderStatusUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    operator fun invoke(body: List<ChangeOrderStatusRequestModel>) = kotlin.runCatching {
        orderRepository.changeOrderStatus(body = body)
    }
}