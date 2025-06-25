package com.example.mercadotest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mercadotest.domain.model.ProductDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel() : ViewModel() {
    private val _products = MutableStateFlow<List<ProductDto>>(emptyList())
    val products: StateFlow<List<ProductDto>> = _products
}