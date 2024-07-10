package com.stackknowledge.datasource.item

import com.stackknowledge.dto.response.item.GetItemResponse
import kotlinx.coroutines.flow.Flow
import remote.response.item.GetItemResponseModel

interface ItemDataSource {
    fun getItem(): Flow<List<GetItemResponse>>
}