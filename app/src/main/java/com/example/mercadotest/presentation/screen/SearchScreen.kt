package com.example.mercadotest.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mercadotest.R
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun SearchScreen(
    recentSearches: List<Int>,
    onSearch: (String) -> Unit = {},
    onBack: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
                .background(Color(0xFFFFEB3B))
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp, start = 4.dp, end = 4.dp)
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Volver",
                modifier = Modifier
                    .size(28.dp)
                    .padding(start = 4.dp)
                    .clickable { onBack() }
            )
            val searchText = remember { mutableStateOf("") }

            TextField(
                value = searchText.value,
                onValueChange = { searchText.value = it },
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {

                    }.semantics { contentDescription = "Campo de búsqueda" },
                label = { Text(stringResource(R.string.search_in_mercadolibre), color = LightGray) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = White,
                    unfocusedContainerColor = White,
                    disabledContainerColor = Color.Transparent,
                    cursorColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {
                    onSearch(searchText.value.lowercase())
                }),
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Gray)
            )
        }

        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(LightGray)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(recentSearches) { search ->
                val item = stringResource(search)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 18.dp)
                        .semantics { contentDescription = "Busqueda recientes $item" },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.outline_history),
                        contentDescription = null,
                        tint = LightGray,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = stringResource(search),
                        color = LightGray,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .weight(1f),
                        fontWeight = FontWeight.Normal
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.arrow_insert),
                        contentDescription = null,
                        tint = LightGray,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
} 