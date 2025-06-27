package com.example.mercadotest.presentation.viewmodel

import androidx.compose.ui.graphics.Color
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
    private val _productsState = MutableStateFlow<UIState<List<ProductDto>>>(UIState.Empty)
    val productsState: StateFlow<UIState<List<ProductDto>>> = _productsState

    private val _mainColor = MutableStateFlow(Color(0xFF3483FA))
    val mainColor: StateFlow<Color> = _mainColor

    fun setMainColor(color: Color) {
        _mainColor.value = color
    }

    fun getProducts(query: String) {
        _productsState.value = UIState.Loading
        viewModelScope.launch {
            try {
                searchUseCase(query).collect { result ->
                    if (result.isSuccessful) {
                        val body = result.body()
                        if (body != null && body.isNotEmpty()) {
                            _productsState.value = UIState.Success(body)
                        } else {
                            _productsState.value = UIState.Empty
                        }
                    } else {
                        _productsState.value = UIState.Error(result.message())
                    }
                }
            } catch (e: Exception) {
                _productsState.value = UIState.Error(e.message ?: "Error desconocido")
            }
        }
    }

    fun getProductById(id: Int): ProductDto? {
        val state = productsState.value
        return if (state is UIState.Success) {
            state.data.find { it.productId == id }
        } else null
    }
}