package com.example.mercadotest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// Modelo de datos para el producto
data class Product(
    val title: String,
    val subtitle: String,
    val price: String,
    val discount: String,
    val installments: String,
    val shipping: String
)

data class Chip(
    val icon: Int,
    val text: String
)

class MainViewModel : ViewModel() {
    private val _products = MutableStateFlow(
        listOf(
            Product(
                title = "Apple iPhone 13 (128 GB)-Blanco estelar",
                subtitle = "Distribuidor Autorizado",
                price = "$1.151.999",
                discount = "52% OFF",
                installments = "Mismo precio en 9 cuotas de $127.999",
                shipping = "Envío gratis"
            ),
            Product(
                title = "Apple iPhone 16 (256 GB)-Rosa",
                subtitle = "",
                price = "$2.125.000",
                discount = "",
                installments = "Mismo precio en 12 cuotas de $177.083",
                shipping = "Llega gratis mañana"
            )
        )
    )
    val products: StateFlow<List<Product>> = _products
} 