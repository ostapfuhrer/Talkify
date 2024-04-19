package com.example.data.mapper

import com.example.data.DataModel
import com.example.domain.DomainModel
import java.math.BigDecimal

internal class DataDomainModelMapper {
    fun map(dataModel: DataModel): DomainModel {
        return DomainModel(BigDecimal(dataModel.property))
    }
}