package com.example.mercadotest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mercadotest.presentation.navigation.AppRoutes.MAIN_SCREEN
import com.example.mercadotest.presentation.screen.MainScreen
import com.example.mercadotest.presentation.viewmodel.MainViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = hiltViewModel()
) {
    NavHost(navController = navController, startDestination = MAIN_SCREEN) {
        composable(MAIN_SCREEN) {
            val products = mainViewModel.products.collectAsState()
            MainScreen(products = products.value)
        }
    }
}