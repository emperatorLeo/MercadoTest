package com.example.mercadotest.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mercadotest.R
import com.example.mercadotest.domain.model.ChipDto
import com.example.mercadotest.domain.model.ProductDto
import com.example.mercadotest.presentation.viewmodel.UIState

@Composable
fun MainScreen(
    productsState: UIState<List<ProductDto>>,
    onSearchBarClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEB3B))
    ) {
        TopBarFull(onSearchBarClick)
        FilterChipsFull()
        Box(modifier = Modifier.fillMaxSize()) {
            when (productsState) {
                is UIState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is UIState.Error -> {
                    Text(
                        text = productsState.message,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                is UIState.Empty -> {
                    Text(
                        text = "No hay productos para mostrar",
                        color = Color.Gray,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                is UIState.Success -> {
                    ProductListFull(productsState.data)
                }
            }
        }
    }
}

@Composable
fun TopBarFull(onSearchBarClick: () -> Unit) {
    Column(
        modifier = Modifier
            .background(Color(0xFFFFEB3B))
            .padding(bottom = 4.dp)
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .height(45.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .clickable { onSearchBarClick() },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = White
                ),
                singleLine = true,
                enabled = false,
                label = { Text("Buscar...", fontSize = 14.sp, color = LightGray) },
            )
            Spacer(Modifier.width(8.dp))
            Icon(Icons.Default.Settings, contentDescription = null, modifier = Modifier.size(28.dp))
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                Icons.Outlined.LocationOn,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Text("Calle Posta 4789", fontSize = 15.sp)
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun FilterChipsFull() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(vertical = 8.dp, horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            listOf(
                ChipDto(R.drawable.race_car, "Llega mañana"),
                ChipDto(R.drawable.outline_credit_card_24, "Mejor precio en cuotas"),
                ChipDto(0, "Enviado por")
            )
        ) {
            ChipWithIcon(it)
        }
    }
}

@Composable
fun ChipWithIcon(chip: ChipDto) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = White,
        border = BorderStroke(1.dp, LightGray)
    ) {
        Row(
            Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (chip.icon != 0) {
                Image(
                    painterResource(chip.icon),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(Modifier.width(4.dp))
            Text(chip.text, fontSize = 14.sp)
        }
    }
}

@Composable
fun ProductListFull(products: List<ProductDto>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        items(products) { product ->
            ProductItemFull(product)
            HorizontalDivider(thickness = 1.dp, color = Color(0xFFE0E0E0))
        }
    }
}

@Composable
fun ProductItemFull(product: ProductDto) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        // Imagen del producto (placeholder)
        Box(
            modifier = Modifier
                .size(110.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.TopEnd
        ) {
            // Aquí podrías usar Coil para cargar la imagen real
            // Icono de favorito (placeholder)
            Box(
                Modifier
                    .padding(6.dp)
                    .size(22.dp)
                    .clip(CircleShape)
                    .background(White),
                contentAlignment = Alignment.Center
            ) {
                Text("❤", fontSize = 14.sp)
            }
        }
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {

            Surface(
                color = Color.Black,
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    "APPLE TIENDA OFICIAL",
                    color = White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
            Spacer(Modifier.height(2.dp))
            Text("APPLE", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
            Text(product.title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(product.store, color = Color.Gray, fontSize = 12.sp)
            Spacer(Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Por Apple ", fontSize = 12.sp, color = Color.Gray)
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(14.dp)
                )
                Text(" 4.9 ", fontSize = 12.sp, color = Color.Gray)
                Text("★ ★ ★ ★ ★", fontSize = 10.sp, color = Color(0xFFFFD700))
                Text(" (38)", fontSize = 12.sp, color = Color.Gray)
            }
            Spacer(Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "$2,399,999",
                    fontSize = 13.sp,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )
                Spacer(Modifier.width(8.dp))
                Text(product.price, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                Spacer(Modifier.width(8.dp))
                Text(
                    product.discount,
                    color = Color(0xFF00A650),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(product.installments, color = Color.Gray, fontSize = 12.sp)
            if (product.shipping.contains("gratis", true)) {
                Text(
                    product.shipping,
                    color = Color(0xFF00A650),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text(product.shipping, color = Color.Gray, fontSize = 13.sp)
            }
            Text("Disponible en 3 colores", color = Color.Gray, fontSize = 12.sp)
        }
    }
}