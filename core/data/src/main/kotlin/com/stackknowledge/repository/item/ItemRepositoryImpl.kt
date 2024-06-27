package com.stackknowledge.repository.item

import com.stackknowledge.datasource.item.ItemDataSource
import kotlinx.coroutines.flow.Flow
import remote.response.item.GetItemResponseModel
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDataSource: ItemDataSource
): ItemRepository {
    override fun getItem(): Flow<GetItemResponseModel> {
        return itemDataSource.getItem()
    }
}