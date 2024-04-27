package com.example.data.repository


import com.example.data.database.model.ItemList
import kotlinx.coroutines.flow.Flow

interface ItemListRepository {

    suspend fun AddList(itemList: ItemList)
    suspend fun UpdateList(itemList: ItemList)
    suspend fun Deleteist(itemList: ItemList)
    fun getAllLists(): Flow<List<ItemList>>
    fun getListByID(id:String): ItemList
}