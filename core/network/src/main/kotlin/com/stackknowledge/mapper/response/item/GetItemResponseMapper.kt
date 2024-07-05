package com.stackknowledge.mapper.response.item

import com.stackknowledge.dto.response.item.GetItemResponse
import com.stackknowledge.mapper.item.toModel
import remote.response.item.GetItemResponseModel

fun GetItemResponse.toModel(): GetItemResponseModel =
    GetItemResponseModel(
        id = id,
        name = name,
        price = price,
        image = image,
    )