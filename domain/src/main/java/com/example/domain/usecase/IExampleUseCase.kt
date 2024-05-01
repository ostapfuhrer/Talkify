package com.example.domain.usecase//package com.example.domain.usecase
//
//import com.example.domain.DomainModel
//import com.example.domain.repository.IExampleRepository
//import javax.inject.Inject
//
//interface IExampleUseCase {
//    suspend fun getMultiplyModels(): List<DomainModel>
//}
//
//internal class ExampleUseCaseImpl @Inject constructor(
//    private val exampleRepository: IExampleRepository
//) : IExampleUseCase {
//    override suspend fun getMultiplyModels(): List<DomainModel> {
//        val model = exampleRepository.getModel()
//        return listOf(model, model, model)
//    }
//}
