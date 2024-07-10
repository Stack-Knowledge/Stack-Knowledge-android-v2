package com.stackknowledge.usecase.item

import com.stackknowledge.repository.item.ItemRepository
import kotlinx.coroutines.flow.Flow
import remote.response.item.GetItemResponseModel
import javax.inject.Inject

class GetItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    operator fun invoke(): Flow<List<GetItemResponseModel>> =
        itemRepository.getItem()
}