package com.example.mercadotest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadotest.domain.model.ProductDto
import com.example.mercadotest.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val searchUseCase: SearchUseCase) : ViewModel() {
    private val _products = MutableStateFlow<List<ProductDto>>(emptyList())
    val products: StateFlow<List<ProductDto>> = _products

    fun getProducts(query: String) {
        viewModelScope.launch {
            searchUseCase(query).collect { result ->
                Log.d("Leo","${result.body()}")
                //_products.value = result
            }
        }
    }
}