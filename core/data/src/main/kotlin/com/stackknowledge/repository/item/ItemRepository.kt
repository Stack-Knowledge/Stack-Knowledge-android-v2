package com.stackknowledge.repository.item

import kotlinx.coroutines.flow.Flow
import remote.response.item.GetItemResponseModel

interface ItemRepository {
    fun getItem(): Flow<GetItemResponseModel>
}