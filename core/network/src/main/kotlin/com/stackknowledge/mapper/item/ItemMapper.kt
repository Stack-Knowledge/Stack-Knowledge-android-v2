package com.stackknowledge.mapper.item

import com.stackknowledge.dto.item.Item
import remote.item.ItemModel

fun Item.toModel(): ItemModel =
    ItemModel(
        id = this.id,
        name = this.name,
        price = this.price,
        image = this.image,
    )