package com.example.mercadotest.domain.usecase

import com.example.mercadotest.data.repository.Repository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke (query: String) = repository.search(query)

}