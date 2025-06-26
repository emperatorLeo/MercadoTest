package com.example.mercadotest.presentation.screen

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.mercadotest.R
import com.example.mercadotest.presentation.components.TopBarFull

@Composable
fun DetailScreen(
    imageUrl: String = "",
    title: String = "Apple iPhone 13 (128 GB)-Blanco estelar-Distribuidor Autorizado",
    store: String = "Apple",
    price: String = "$1.151.999",
    discount: String = "52% OFF",
    installments: String = "Mismo precio en 9 cuotas de $127.999",
    shipping: String = "Llega gratis el sábado",
    stock: String = "Stock disponible",
    description: String = "El iPhone 14 viene con el sistema de dos cámaras más impresionante en un iPhone 14, para que tomes fotos espectaculares con mucha o poca luz. Y te da más tranquilidad gracias a una funcionalidad de seguridad que salva vidas.",
    legal: String = "(1) La pantalla tiene las esquinas redondeadas...",
    onSearchBarClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .verticalScroll(rememberScrollState())
    ) {
        TopBarFull(true, onSearchBarClick = onSearchBarClick) { onBackClick }

        // Datos principales
        Column(Modifier.padding(16.dp)) {
            Text("Nuevo  •  +100 vendidos", color = Color.Gray, fontSize = 13.sp)
            Spacer(Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.weight(1f))
                Text("4.9 ★ (381)", color = Color.Gray, fontSize = 13.sp)
            }
            Spacer(Modifier.height(6.dp))
            Surface(
                color = Color.Black,
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    "$store TIENDA OFICIAL",
                    color = White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
            Spacer(Modifier.height(12.dp))
            // Imagen principal
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize(),
                    placeholder = painterResource(id = R.drawable.placeholder),
                    error = painterResource(id = R.drawable.error_image)
                )
            }
            Spacer(Modifier.height(12.dp))
            // Precio y cuotas
            Text(price, fontWeight = FontWeight.Bold, fontSize = 28.sp)
            Text(discount, color = Color(0xFF00A650), fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(installments, color = Color.Gray, fontSize = 14.sp)
            Spacer(Modifier.height(8.dp))
            // Envío y stock
            Text(shipping, color = Color(0xFF00A650), fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text(stock, color = Color.Gray, fontSize = 13.sp)
            Spacer(Modifier.height(8.dp))
            // Botones de acción
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = { /* Comprar ahora */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3483FA))
                ) {
                    Text("Comprar ahora", color = White, fontWeight = FontWeight.Bold)
                }
                Button(
                    onClick = { /* Agregar al carrito */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE3EDFB))
                ) {
                    Text("Agregar al carrito", color = Color(0xFF3483FA), fontWeight = FontWeight.Bold)
                }
            }
            Spacer(Modifier.height(16.dp))
            // Tienda oficial y vendedor
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.storefront),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Column(Modifier.padding(start = 8.dp)) {
                    Text("Tienda oficial $store", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Text("Vendido por MACSTATION OFICIAL", color = Color.Gray, fontSize = 13.sp)
                    Text("+10mil ventas", color = Color.Gray, fontSize = 13.sp)
                }
            }
            Spacer(Modifier.height(16.dp))
            // Descripción
            Text("Descripción", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(description, fontSize = 15.sp, modifier = Modifier.padding(top = 4.dp))
            Spacer(Modifier.height(12.dp))
            // Aviso legal
            Text("Aviso legal", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(legal, fontSize = 13.sp, modifier = Modifier.padding(top = 2.dp))
        }
    }
} 