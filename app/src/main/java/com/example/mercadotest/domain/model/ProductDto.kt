package com.example.mercadotest.domain.model

data class ProductDto(
    val productId: Int,
    val title: String,
    val store: String,
    val image: List<String>,
    val price: String,
    val discount: String,
    val installments: String,
    val shipping: String,
    val description: String,
    val legal: String,
)