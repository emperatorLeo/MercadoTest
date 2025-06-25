package com.example.mercadotest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mercadotest.domain.model.ProductDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    val products: StateFlow<List<ProductDto>> = MutableStateFlow(
        listOf(
            ProductDto(
                title = "Apple iPhone 13 (128 GB)-Blanco estelar",
                subtitle = "Distribuidor Autorizado",
                price = "$1.151.999",
                discount = "52% OFF",
                installments = "Mismo precio en 9 cuotas de $127.999",
                shipping = "Envío gratis"
            ),
            ProductDto(
                title = "Apple iPhone 16 (256 GB)-Rosa",
                subtitle = "",
                price = "$2.125.000",
                discount = "",
                installments = "Mismo precio en 12 cuotas de $177.083",
                shipping = "Llega gratis mañana"
            )
        )
    )
}