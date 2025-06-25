package com.example.mercadotest.domain.usecase

import com.example.mercadotest.data.repository.Repository

class SearchUseCase(private val repository: Repository) {
    suspend operator fun invoke (query: String) = repository.search(query)

}