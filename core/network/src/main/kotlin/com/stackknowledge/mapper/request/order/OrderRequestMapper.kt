package com.stackknowledge.mapper.request.order

import com.stackknowledge.dto.request.order.OrderRequest
import remote.request.order.OrderRequestModel

fun OrderRequestModel.toDto(): OrderRequest =
    OrderRequest(
        itemId = itemId,
        count = count
    )