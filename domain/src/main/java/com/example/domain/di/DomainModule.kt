package com.example.domain.di

import com.example.domain.usecase.ExampleUseCaseImpl
import com.example.domain.usecase.IExampleUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    @Binds
    internal abstract fun bindsExampleUseCase(exampleUseCaseImpl: ExampleUseCaseImpl): IExampleUseCase
}