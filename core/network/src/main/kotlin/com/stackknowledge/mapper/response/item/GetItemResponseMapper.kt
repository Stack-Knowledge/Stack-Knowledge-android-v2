package com.stackknowledge.mapper.response.item

import com.stackknowledge.dto.response.item.GetItemResponse
import remote.response.item.GetItemResponseModel

fun GetItemResponse.toModel(): GetItemResponseModel =
    GetItemResponseModel(
        id = this.itemId,
        name = this.name,
        price = this.price,
        image = this.image,
    )