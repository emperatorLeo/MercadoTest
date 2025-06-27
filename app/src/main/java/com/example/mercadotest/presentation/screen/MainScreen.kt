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
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.mercadotest.R
import com.example.mercadotest.domain.model.ChipDto
import com.example.mercadotest.domain.model.ProductDto
import com.example.mercadotest.presentation.components.EmptyStateComponent
import com.example.mercadotest.presentation.components.ErrorStateComponent
import com.example.mercadotest.presentation.components.TopBarFull
import com.example.mercadotest.presentation.viewmodel.UIState

@Composable
fun MainScreen(
    productsState: UIState<List<ProductDto>>,
    onSearchBarClick: () -> Unit,
    onProductClick: (Int) -> Unit,
    mainColor: Color,
    onColorSelected: (Color) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEB3B))
    ) {
        TopBarFull(
            onSearchBarClick = onSearchBarClick,
            mainColor = mainColor,
            onColorSelected = onColorSelected
        )
        FilterChipsFull()
        Box(modifier = Modifier.fillMaxSize()) {
            when (productsState) {
                is UIState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(100.dp),
                        color = mainColor
                    )
                }
                is UIState.Error -> {
                    ErrorStateComponent(productsState.message)
                }
                is UIState.Empty -> {
                    EmptyStateComponent()
                }
                is UIState.Success -> {
                    ProductListFull(productsState.data, onProductClick, mainColor)
                }
            }
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
                ChipDto(R.drawable.race_car, R.string.arrives_tomorrow),
                ChipDto(R.drawable.outline_credit_card_24, R.string.best_price_installments),
                ChipDto(0, R.string.shipped_by)
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
            Text(stringResource(chip.text), fontSize = 14.sp)
        }
    }
}

@Composable
fun ProductListFull(products: List<ProductDto>, onProductClick: (Int) -> Unit, mainColor: Color) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        items(products) { product ->
            ProductItemFull(product, onProductClick, mainColor)
            HorizontalDivider(thickness = 1.dp, color = Color(0xFFE0E0E0))
        }
    }
}

@Composable
fun ProductItemFull(product: ProductDto, onProductClick: (Int) -> Unit, mainColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onProductClick(product.productId) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(width = 110.dp, height = 110.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.TopEnd
        ) {
            AsyncImage(
                model = product.image.firstOrNull(),
                contentDescription = stringResource(R.string.product_image_content_description, product.title),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp)),
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.error_image)
            )
            Box(
                Modifier
                    .padding(6.dp)
                    .size(22.dp)
                    .clip(CircleShape)
                    .background(White),
                contentAlignment = Alignment.Center
            ) {
                Text(stringResource(R.string.heart), fontSize = 14.sp)
            }
        }
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
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
            Spacer(Modifier.height(2.dp))
            Text(product.store, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
            Text(product.title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(product.store, color = Color.Gray, fontSize = 12.sp)
            Spacer(Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(stringResource(R.string.by_store,product.store), fontSize = 12.sp, color = Color.Gray)
                Icon(
                    Icons.Rounded.CheckCircle,
                    contentDescription = stringResource(R.string.verified_icon_content_description),
                    tint = mainColor,
                    modifier = Modifier.size(14.dp)
                )
                Text(stringResource(R.string.grades), fontSize = 12.sp, color = Color.Gray)
                Text(stringResource(R.string.stars), fontSize = 10.sp, color = mainColor)
                Text(stringResource(R.string.therty_eight), fontSize = 12.sp, color = Color.Gray)
            }
            Spacer(Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    stringResource(R.string.price_discount),
                    fontSize = 13.sp,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )
                Spacer(Modifier.width(8.dp))
                Text(product.price, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                Spacer(Modifier.width(8.dp))
                Text(product.discount, color = Color(0xFF00A650), fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
            Text(product.installments, color = Color.Gray, fontSize = 12.sp)
            if (product.shipping.contains("gratis", true)) {
                Text(product.shipping, color = Color(0xFF00A650), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            } else {
                Text(product.shipping, color = Color.Gray, fontSize = 13.sp)
            }
            Text(stringResource(R.string.available_in_colors), color = Color.Gray, fontSize = 12.sp)
        }
    }
}