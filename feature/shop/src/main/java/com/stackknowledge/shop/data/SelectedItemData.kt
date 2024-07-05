package com.stackknowledge.shop.data

import java.util.UUID

data class SelectedItemData(
    val id: UUID,
    val name: String,
    val count: Int,
    val price: Int,
)
