package com.example.data.di

import com.example.data.repository.ExampleRepository
import com.example.domain.repository.IExampleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindExampleRepository(exampleRepository: ExampleRepository): IExampleRepository
}