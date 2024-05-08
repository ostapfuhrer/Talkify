package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.database.model.ItemList
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addList(itemList: ItemList)

    @Update
    suspend fun updateList(itemList: ItemList)

    @Delete
    suspend fun deleteList(itemList: ItemList)


    @Query("Select * from AppLists")
     fun getAllLists(): Flow<List<ItemList>>

    @Query("Select * from AppLists where id =:id")
    suspend fun getListByID(id:String): ItemList
}