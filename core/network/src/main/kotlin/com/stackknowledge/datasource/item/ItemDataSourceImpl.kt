package com.stackknowledge.datasource.item

import com.stackknowledge.api.ItemAPI
import com.stackknowledge.dto.response.item.GetItemResponse
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import remote.response.item.GetItemResponseModel
import javax.inject.Inject

class ItemDataSourceImpl @Inject constructor(
    private val itemAPI: ItemAPI
): ItemDataSource {
    override fun getItem(): Flow<List<GetItemResponse>> = flow {
        emit(
            StackKnowledgeApiHandler<List<GetItemResponse>>()
                .httpRequest { itemAPI.getItem() }
                .sendRequest()
        )
    }
}