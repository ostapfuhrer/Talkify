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
    suspend fun AddList(itemList: ItemList)

    @Update
    suspend fun UpdateList(itemList: ItemList)

    @Delete
    suspend fun Deleteist(itemList: ItemList)


    @Query("Select * from AppLists")
    fun getAllLists(): Flow<List<ItemList>>

    @Query("Select * from AppLists where id =:id")
    fun getBookByID(id:Int): ItemList
}