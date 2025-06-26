package com.example.mercadotest.data.model

import com.example.mercadotest.domain.model.ProductDto

data class ProductItemResponse(
    val id: Int,
    val productName: String,
    val imageUrl: String,
    val storeName: String,
    val price: String,
    val discount: String,
    val installments: String,
    val shipping: String,
    val description: String,
    val legal: String
) {
    fun fromResponseToDto(): ProductDto {
        return ProductDto(
            id,
            productName,
            storeName,
            imageUrl,
            price,
            discount,
            installments,
            shipping,
            description,
            legal
        )
    }
}
