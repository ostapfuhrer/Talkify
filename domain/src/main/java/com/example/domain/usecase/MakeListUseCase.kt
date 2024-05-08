package com.example.domain.usecase


import com.example.data.repository.ItemListRepository
import com.example.domain.utiles.ItemUI
import com.example.domain.utiles.allItems
import javax.inject.Inject

class MakeListUseCase @Inject constructor(
    private val itemListRepository: ItemListRepository,
) {
    suspend operator fun invoke(id: String): List<ItemUI> {
        val idList = itemListRepository.getListByID(id).itemList
        return idList.mapNotNull { allItems.getOrNull(it) }
    }
}
