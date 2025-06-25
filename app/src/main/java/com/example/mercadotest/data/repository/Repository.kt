package com.example.mercadotest.data.repository

import com.example.mercadotest.domain.model.ProductDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {
   suspend fun search(query: String): Flow<Response<List<ProductDto>>>
}