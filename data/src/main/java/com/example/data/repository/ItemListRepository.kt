package com.example.data.repository


import com.example.data.database.model.ItemList
import kotlinx.coroutines.flow.Flow

interface ItemListRepository {

    suspend fun addList(itemList: ItemList)
    suspend fun updateList(itemList: ItemList)
    suspend fun deleteList(itemList: ItemList)
    fun getAllLists(): Flow<List<ItemList>>
    fun getListByID(id:String): ItemList
}