package com.stackknowledge.repository.item

import com.stackknowledge.datasource.item.ItemDataSource
import com.stackknowledge.mapper.response.item.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import remote.response.item.GetItemResponseModel
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDataSource: ItemDataSource
): ItemRepository {
    override fun getItem(): Flow<List<GetItemResponseModel>> {
        return itemDataSource.getItem().map { list -> list.map { it.toModel() } }
    }
}