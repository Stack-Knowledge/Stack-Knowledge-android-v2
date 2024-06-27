package com.stackknowledge.mapper.request.order

import com.stackknowledge.dto.request.order.ChangeOrderStatusRequest
import remote.request.order.ChangeOrderStatusRequestModel

fun ChangeOrderStatusRequestModel.toDto(): ChangeOrderStatusRequest =
    ChangeOrderStatusRequest(
        orderId = this.orderId,
        count = this.count,
    )