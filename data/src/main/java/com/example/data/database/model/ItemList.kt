package com.example.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.data.database.TypeConverter

@Entity(tableName = "AppLists")
@TypeConverters(TypeConverter::class)
data class ItemList(
    @PrimaryKey(autoGenerate = false)
    val id:String= "",
    val ItemList:List<Int> =  emptyList(),
)
