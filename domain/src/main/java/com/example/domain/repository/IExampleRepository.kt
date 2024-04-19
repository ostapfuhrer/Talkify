package com.example.domain.repository

import com.example.domain.DomainModel

interface IExampleRepository {
    suspend fun getModel(): DomainModel
}