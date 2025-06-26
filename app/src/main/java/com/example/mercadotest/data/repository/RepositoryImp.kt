package com.example.mercadotest.data.repository

import com.example.mercadotest.data.apisource.ApiDataSource
import com.example.mercadotest.domain.model.ProductDto
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.Response.error
import retrofit2.Response.success

class RepositoryImp(private val dataSource: ApiDataSource): Repository {

    override suspend fun search(query: String) = flow<Response<List<ProductDto>>> {
       dataSource.getSearch(query).collect {
           if (it.isSuccessful) {
               val dtoList = it.body()?.map { response -> response.fromResponseToDto() }
               emit(success(dtoList))
           } else {
               emit(error(it.errorBody()!!,it.raw()))
           }
       }
    }
}