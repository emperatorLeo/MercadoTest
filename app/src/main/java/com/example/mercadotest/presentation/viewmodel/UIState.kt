package com.example.mercadotest.presentation.viewmodel

sealed class UIState<out T> {
    object Loading : UIState<Nothing>()
    data class Success<T>(val data: T) : UIState<T>()
    data class Error(val message: String) : UIState<Nothing>()
    object Empty : UIState<Nothing>()
} 