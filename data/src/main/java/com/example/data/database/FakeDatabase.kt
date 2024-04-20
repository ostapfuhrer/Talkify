package com.example.data.database

import com.example.data.DataModel
import javax.inject.Inject

internal class FakeDatabase @Inject constructor(

) {
    suspend fun getData(): DataModel {
        return DataModel(0.33)
    }
}