package com.example.data.di

import android.app.Application
import com.example.data.database.ItemListDao
import com.example.data.database.ItemListDataBase
import com.example.data.repository.DefaultContainer
import com.example.data.repository.ItemListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 class DataModule {

    companion object {
        @Provides
        fun provideBookDao(app: Application): ItemListDao {
            return ItemListDataBase.getDataBase(app).ItemListDao()
        }

        @Provides
        fun provideBookRepo(listDao: ItemListDao): ItemListRepository {
            return DefaultContainer(listDao)
        }
    }
}
//@Module
//@InstallIn(SingletonComponent::class)
//class DataModule {
//
//    @Provides
//    @Singleton
//    fun provideDatabase(app: Application): ItemListDataBase {
//        return Room.databaseBuilder(app, ItemListDataBase::class.java, "ItemList_database2")
//            .allowMainThreadQueries() // Зауважте, що це не рекомендований підхід, краще використовувати асинхронні запити.
//            .fallbackToDestructiveMigration()
//            .addCallback(object : RoomDatabase.Callback() {
//                override fun onCreate(db: SupportSQLiteDatabase) {
//                    super.onCreate(db)
//                    Executors.newSingleThreadExecutor().execute {
//                        val dao = ItemListDataBase.getDataBase(app).ItemListDao()
//                        dao.addList(ItemList("Fruits", (0..20).toList()))
//                        dao.addList(ItemList("Transport", (21..41).toList()))
//                        dao.addList(ItemList("Emotions", (42..57).toList()))
//                        dao.addList(ItemList("Custom", emptyList()))
//                    }
//                }
//            })
//            .build()
//
//    }
//
//    @Provides
//    fun provideListDao(database: ItemListDataBase): ItemListDao {
//        return database.ItemListDao()
//    }
//
//    @Provides
//    fun provideListRepo(listDao: ItemListDao): ItemListRepository {
//        return DefaultContainer(listDao)
//    }
//}
