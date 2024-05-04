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
