package com.example.data.repository

import com.example.data.database.ItemListDao
import com.example.data.database.model.ItemList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultContainer @Inject constructor(private val itemListDao: ItemListDao): ItemListRepository {
    override suspend fun AddList(itemList: ItemList) =itemListDao.AddList(itemList)

    override suspend fun UpdateList(itemList: ItemList) = itemListDao.UpdateList(itemList)
    override suspend fun Deleteist(itemList: ItemList) = itemListDao.Deleteist(itemList)

    override fun getAllLists(): Flow<List<ItemList>>  = itemListDao.getAllLists()

    override fun getBookByID(id: Int): ItemList = itemListDao.getBookByID(id)
}