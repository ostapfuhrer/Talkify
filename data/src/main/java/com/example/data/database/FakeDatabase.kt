package com.example.data.database

import com.example.data.DataModel

internal class FakeDatabase {
    suspend fun getData(): DataModel {
        return DataModel(0.33)
    }
}