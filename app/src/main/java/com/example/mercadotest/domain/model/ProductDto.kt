package com.example.mercadotest.domain.model

data class ProductDto(
    val title: String,
    val subtitle: String,
    val price: String,
    val discount: String,
    val installments: String,
    val shipping: String
)