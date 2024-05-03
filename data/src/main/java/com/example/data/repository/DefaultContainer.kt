package com.example.data.repository

import com.example.data.database.ItemListDao
import com.example.data.database.model.ItemList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultContainer @Inject constructor(private val itemListDao: ItemListDao): ItemListRepository {


    override suspend fun addList(itemList: ItemList) =itemListDao.addList(itemList)
    override suspend fun updateList(itemList: ItemList) = itemListDao.updateList(itemList)
    override suspend fun deleteList(itemList: ItemList)  = itemListDao.deleteList(itemList)
    override fun getAllLists(): Flow<List<ItemList>>  = itemListDao.getAllLists()

    override   suspend fun getListByID(id:String): ItemList = itemListDao.getListByID(id)
}