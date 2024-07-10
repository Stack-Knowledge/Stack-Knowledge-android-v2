package com.stackknowledge.mapper.request.order

import com.stackknowledge.dto.request.order.Orders
import remote.request.order.OrdersModel

fun OrdersModel.toDto(): Orders =
    Orders(
        itemId = this.itemId,
        count = this.count,
    )