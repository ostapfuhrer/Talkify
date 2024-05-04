package com.example.domain.di

import com.example.data.repository.ItemListRepository
import com.example.domain.usecase.GetListUseCase
import com.example.domain.usecase.MakeListUseCase
import com.example.domain.usecase.UpdateListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    companion object {
        @Provides
        fun provideUpdateListUseCase(itemListRepository: ItemListRepository): UpdateListUseCase {
            return UpdateListUseCase(itemListRepository)
        }

        @Provides
        fun provideGetListUseCase(itemListRepository: ItemListRepository): GetListUseCase {
            return GetListUseCase(itemListRepository)
        }

        @Provides
        fun provideMakeListUseCase(itemListRepository: ItemListRepository): MakeListUseCase {
            return MakeListUseCase(itemListRepository)
        }

    }
}