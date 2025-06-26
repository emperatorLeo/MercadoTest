package com.example.mercadotest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mercadotest.common.EMPTY_LOTTIE_URI
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource

@Composable
fun EmptyStateComponent() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            DotLottieAnimation(
                source = DotLottieSource.Json(EMPTY_LOTTIE_URI),
                autoplay = true,
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 10.dp),
                loop = true
            )

            Text(
                text = "No hay productos para mostrar",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}