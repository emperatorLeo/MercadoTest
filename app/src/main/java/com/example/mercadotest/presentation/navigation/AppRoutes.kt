package com.example.mercadotest.presentation.navigation

object AppRoutes {
    const val PRODUCT_ID = "product_id"
    const val QUERY_SEARCH = "query_search"
    const val MAIN_SCREEN = "main_screen/{$QUERY_SEARCH}"
    const val SEARCH_SCREEN = "search_screen"
    const val DETAIL_SCREEN = "detail_screen/{$PRODUCT_ID}"
}