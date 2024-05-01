package com.example.domain.usecase

import com.example.data.database.model.ItemList
import com.example.data.repository.ItemListRepository
import javax.inject.Inject

class AddListUseCase @Inject constructor(private  val itemListRepository: ItemListRepository){
    suspend operator fun invoke(itemList: ItemList) {
        itemListRepository.AddList(itemList)
    }
}