package com.example.domain.di

import com.example.data.repository.ItemListRepository
import com.example.domain.usecase.AddListUseCase
//import com.example.domain.usecase.ExampleUseCaseImpl
import com.example.domain.usecase.GetListUseCase
//import com.example.domain.usecase.IExampleUseCase
import com.example.domain.usecase.UpdateListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
//    @Binds
//    internal abstract fun bindsExampleUseCase(exampleUseCaseImpl: ExampleUseCaseImpl): IExampleUseCase
    companion object {
        @Provides
        fun provideAddListUseCase(itemListRepository:ItemListRepository): AddListUseCase {
           return AddListUseCase(itemListRepository)

        }
        @Provides
        fun provideUpdateListUseCase(itemListRepository:ItemListRepository): UpdateListUseCase {
           return UpdateListUseCase(itemListRepository)
        }
        @Provides
        fun provideGetListUseCase(itemListRepository:ItemListRepository): GetListUseCase {
           return GetListUseCase(itemListRepository)
        }


    }
}