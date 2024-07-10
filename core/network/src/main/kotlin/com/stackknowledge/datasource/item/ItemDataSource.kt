package com.stackknowledge.datasource.item

import kotlinx.coroutines.flow.Flow
import remote.response.item.GetItemResponseModel

interface ItemDataSource {
    fun getItem(): Flow<GetItemResponseModel>
}