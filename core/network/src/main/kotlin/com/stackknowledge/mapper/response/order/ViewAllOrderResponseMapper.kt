package com.stackknowledge.mapper.response.order

import com.stackknowledge.dto.response.order.ViewAllOrderResponse
import com.stackknowledge.mapper.item.toModel
import com.stackknowledge.mapper.user.toModel
import remote.response.order.ViewAllOrderResponseModel

fun ViewAllOrderResponse.toModel(): ViewAllOrderResponseModel =
    ViewAllOrderResponseModel(
        id = this.id,
        count = this.count,
        price = this.price,
        item = this.item.toModel(),
        user = this.user.toModel(),
    )