package com.example.data.repository

import com.example.data.database.FakeDatabase
import com.example.data.mapper.DataDomainModelMapper
import com.example.domain.DomainModel
import com.example.domain.repository.IExampleRepository

internal class ExampleRepository(
    private val dataDomainModelMapper: DataDomainModelMapper,
    private val fakeDatabase: FakeDatabase,
) : IExampleRepository {
    override suspend fun getModel(): DomainModel {
        return dataDomainModelMapper.map(fakeDatabase.getData())
    }
}