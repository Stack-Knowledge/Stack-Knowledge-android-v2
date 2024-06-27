package com.stackknowledge.usecase.item

import com.stackknowledge.repository.item.ItemRepository
import javax.inject.Inject

class GetItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    operator fun invoke() = runCatching {
        itemRepository.getItem()
    }
}