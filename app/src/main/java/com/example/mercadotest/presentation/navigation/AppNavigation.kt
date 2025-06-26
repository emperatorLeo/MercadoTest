package com.example.mercadotest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mercadotest.common.IPHONE
import com.example.mercadotest.presentation.navigation.AppRoutes.MAIN_SCREEN
import com.example.mercadotest.presentation.navigation.AppRoutes.QUERY_SEARCH
import com.example.mercadotest.presentation.navigation.AppRoutes.SEARCH_SCREEN
import com.example.mercadotest.presentation.screen.MainScreen
import com.example.mercadotest.presentation.screen.SearchScreen
import com.example.mercadotest.presentation.viewmodel.MainViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = hiltViewModel()
) {
    NavHost(navController = navController, startDestination = MAIN_SCREEN) {
        composable(MAIN_SCREEN, arguments = listOf(navArgument(QUERY_SEARCH) {
            type = StringType
        })) { navBackStackEntry ->
            val query = navBackStackEntry.arguments?.getString(QUERY_SEARCH) ?: IPHONE
            LaunchedEffect(Unit) {
                mainViewModel.getProducts(query)
            }

            val products = mainViewModel.productsState.collectAsState()

            MainScreen(products.value) {
                navController.navigate(SEARCH_SCREEN)
            }
        }
        composable(SEARCH_SCREEN) {
            SearchScreen(
                recentSearches = listOf("iphone", "samsung", "pelota"),
                onSearch = { query ->
                    navController.navigate(MAIN_SCREEN.replace("{${QUERY_SEARCH}}",query)) {
                        popUpTo(MAIN_SCREEN) {
                            inclusive = true
                        }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
    }
}