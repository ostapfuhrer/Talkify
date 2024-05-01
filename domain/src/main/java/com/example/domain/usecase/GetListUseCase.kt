package com.example.domain.usecase

import com.example.data.database.model.ItemList
import com.example.data.repository.ItemListRepository
import javax.inject.Inject

class GetListUseCase @Inject constructor(private  val itemListRepository: ItemListRepository) {
    suspend operator fun invoke(id:String):ItemList {
         return itemListRepository.getListByID(id)
    }
}