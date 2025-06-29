package com.example.mercadotest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mercadotest.R
import com.example.mercadotest.common.IPHONE
import com.example.mercadotest.presentation.navigation.AppRoutes.DETAIL_SCREEN
import com.example.mercadotest.presentation.navigation.AppRoutes.MAIN_SCREEN
import com.example.mercadotest.presentation.navigation.AppRoutes.PRODUCT_ID
import com.example.mercadotest.presentation.navigation.AppRoutes.QUERY_SEARCH
import com.example.mercadotest.presentation.navigation.AppRoutes.SEARCH_SCREEN
import com.example.mercadotest.presentation.screen.DetailScreen
import com.example.mercadotest.presentation.screen.MainScreen
import com.example.mercadotest.presentation.screen.SearchScreen
import com.example.mercadotest.presentation.viewmodel.MainViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val mainColor by mainViewModel.mainColor.collectAsState()
    NavHost(navController = navController, startDestination = MAIN_SCREEN) {
        composable(MAIN_SCREEN, arguments = listOf(navArgument(QUERY_SEARCH) {
            type = StringType
        })) { navBackStackEntry ->
            val query = navBackStackEntry.arguments?.getString(QUERY_SEARCH) ?: IPHONE
            LaunchedEffect(Unit) {
                mainViewModel.getProducts(query)
            }

            val products = mainViewModel.productsState.collectAsState()

            MainScreen(
                productsState = products.value,
                onSearchBarClick = {
                    navController.navigate(SEARCH_SCREEN)
                },
                onProductClick = { productId ->
                    navController.navigate(
                        DETAIL_SCREEN.replace(
                            "{${PRODUCT_ID}}",
                            productId.toString()
                        )
                    )
                },
                mainColor = mainColor,
                onColorSelected = { mainViewModel.setMainColor(it) }
            )
        }
        composable(SEARCH_SCREEN) {
            SearchScreen(
                recentSearches = listOf(R.string.iphone, R.string.samsung,R.string.pelota),
                onSearch = { query ->
                    if (query.isEmpty()) {
                        navController.popBackStack()
                    } else {
                        navController.navigate(MAIN_SCREEN.replace("{${QUERY_SEARCH}}", query)) {
                            popUpTo(MAIN_SCREEN) {
                                inclusive = true
                            }
                        }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable(
            route = DETAIL_SCREEN,
            arguments = listOf(navArgument(PRODUCT_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt(PRODUCT_ID) ?: 0
            val product = mainViewModel.getProductById(productId)
            if (product != null) {
                DetailScreen(
                    product = product,
                    mainColor = mainColor,
                    { navController.navigate(SEARCH_SCREEN) }
                ) {
                    navController.popBackStack()
                }
            }
        }
    }
}