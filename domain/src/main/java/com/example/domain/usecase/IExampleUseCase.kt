package com.example.domain.usecase

import com.example.domain.DomainModel
import com.example.domain.repository.IExampleRepository

interface IExampleUseCase {
    suspend fun getMultiplyModels(): List<DomainModel>
}

internal class ExampleUseCaseImpl(
    private val exampleRepository: IExampleRepository
) : IExampleUseCase {
    override suspend fun getMultiplyModels(): List<DomainModel> {
        val model = exampleRepository.getModel()
        return listOf(model, model, model)
    }
}
