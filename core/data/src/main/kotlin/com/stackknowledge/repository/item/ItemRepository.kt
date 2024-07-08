package com.stackknowledge.repository.item

import com.stackknowledge.dto.response.item.GetItemResponse
import kotlinx.coroutines.flow.Flow
import remote.response.item.GetItemResponseModel

interface ItemRepository {
    fun getItem(): Flow<List<GetItemResponseModel>>
}