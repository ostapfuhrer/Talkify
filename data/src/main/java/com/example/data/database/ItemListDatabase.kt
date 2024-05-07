package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.data.database.model.ItemList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

@Database(entities = arrayOf(ItemList::class), version = 2)
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
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Executors.newSingleThreadExecutor().execute {
                                GlobalScope.launch(Dispatchers.IO) {
                                    val dao = Instance!!.ItemListDao()
                                    dao.addList(ItemList("Fruits", (0..20).toList()))
                                    dao.addList(ItemList("Transport", (21..41).toList()))
                                    dao.addList(ItemList("Emotions", (42..57).toList()))
                                    dao.addList(ItemList("Custom", emptyList()))
                                }
                            }
                        }
                    })
                    .build()
                    .also { Instance = it }
            }

        }

    }
}
