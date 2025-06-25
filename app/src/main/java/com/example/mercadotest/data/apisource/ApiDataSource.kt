package com.example.mercadotest.data.apisource

import com.example.mercadotest.data.model.ProductItemResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiDataSource {
    suspend fun getSearch(query: String): Flow<Response<List<ProductItemResponse>>>

}