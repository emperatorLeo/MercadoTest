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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.mercadotest.R
import com.example.mercadotest.domain.model.ProductDto
import com.example.mercadotest.presentation.components.TopBarFull

@Composable
fun DetailScreen(
    product: ProductDto,
    mainColor: Color,
    onSearchBarClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    val pagerState = rememberPagerState(0, pageCount = {product.image.size})

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .verticalScroll(rememberScrollState())
    ) {
        TopBarFull(true, onSearchBarClick = onSearchBarClick, onBackClick = onBackClick)

        Column(Modifier.padding(16.dp)) {
            Text(stringResource(R.string.new_and_sold), color = Color.Gray, fontSize = 13.sp)
            Spacer(Modifier.height(2.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    product.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.weight(1f)
                )
                Text(stringResource(R.string.star_rating), color = Color.Gray, fontSize = 13.sp)
            }
            Spacer(Modifier.height(6.dp))
            Surface(
                color = Color.Black,
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    stringResource(R.string.official_store, product.store),
                    color = White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
            Spacer(Modifier.height(12.dp))

            if (product.image.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFE0E0E0)),
                    contentAlignment = Alignment.Center
                ) {
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.fillMaxSize()
                    ) { page ->
                        AsyncImage(
                            model = product.image[page],
                            contentDescription = stringResource(R.string.product_image_content_description, product.title),
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize(),
                            placeholder = painterResource(id = R.drawable.placeholder),
                            error = painterResource(id = R.drawable.error_image)
                        )
                    }

                    Row(
                        Modifier
                            .align(Alignment.BottomCenter)
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(product.image.size) { index ->
                            val selected = pagerState.currentPage == index
                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .size(if (selected) 10.dp else 8.dp)
                                    .clip(CircleShape)
                                    .background(if (selected) mainColor else Color.LightGray)
                            )
                        }
                    }
                }
            }
            Spacer(Modifier.height(12.dp))

            Text(product.price, fontWeight = FontWeight.Bold, fontSize = 28.sp)
            Text(
                product.discount,
                color = Color(0xFF00A650),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(product.installments, color = Color.Gray, fontSize = 14.sp)
            Spacer(Modifier.height(8.dp))

            Text(
                product.shipping,
                color = Color(0xFF00A650),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.stock_available), color = Color.Gray, fontSize = 13.sp)
            Spacer(Modifier.height(8.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f)
                        .semantics { contentDescription = "Botón comprar ahora" }
                        .semantics { role = Role.Button },
                    colors = ButtonDefaults.buttonColors(containerColor = mainColor)
                ) {
                    Text(
                        stringResource(R.string.buy_now),
                        color = White,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f)
                        .semantics { contentDescription = "Botón agregar al carrito" }
                        .semantics { role = Role.Button },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE3EDFB)),
                ) {
                    Text(
                        stringResource(R.string.add_to_cart),
                        color = mainColor,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.storefront),
                    contentDescription = stringResource(R.string.store_icon_content_description),
                    modifier = Modifier
                        .size(24.dp)
                        .semantics { contentDescription = "Icono de tienda" }
                        .semantics { role = Role.Image },
                )
                Column(Modifier.padding(start = 8.dp)) {
                    Text(
                        stringResource(R.string.official_store, product.store),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text(
                        stringResource(R.string.sold_by_macstation),
                        color = Color.Gray,
                        fontSize = 13.sp
                    )
                    Text(
                        stringResource(R.string.ten_thousand_products),
                        color = Color.Gray,
                        fontSize = 13.sp
                    )
                }
            }
            Spacer(Modifier.height(16.dp))

            Text(
                stringResource(R.string.description),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(product.description, fontSize = 15.sp, modifier = Modifier.padding(top = 4.dp))
            Spacer(Modifier.height(12.dp))

            Text(
                stringResource(R.string.legal_notice),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(product.legal, fontSize = 13.sp, modifier = Modifier.padding(top = 2.dp))
        }
    }
} 