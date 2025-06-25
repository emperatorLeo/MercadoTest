package com.example.mercadotest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.mercadotest.presentation.screen.MainScreen
import com.example.mercadotest.presentation.theme.MercadoTestTheme
import com.example.mercadotest.presentation.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MercadoTestTheme {
                val products = viewModel.products.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    MainScreen(products = products.value)
                }
            }
        }
    }
}
