package com.example.domain.usecase


import com.example.data.repository.ItemListRepository
import javax.inject.Inject

class MakeListUseCase @Inject constructor(
    private val itemListRepository: ItemListRepository,

) {


//    suspend operator fun invoke(id: String, allItems: List<Item>) : List<Item>{
//        val idList = itemListRepository.getListByID(id).itemList
//       return idList.mapNotNull { allItems.getOrNull(it) }
//
//    }
}
