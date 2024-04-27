package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.database.model.ItemList

@Database(entities = arrayOf(ItemList::class), version = 1)
abstract  class ItemListDataBase : RoomDatabase() {

    abstract fun ItemListDao():ItemListDao

    companion object{
        @Volatile
        private var Instance : ItemListDataBase? = null

        fun getDataBase( context: Context): ItemListDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ItemListDataBase::class.java, "ItemLIst_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }

        }

    }
}
