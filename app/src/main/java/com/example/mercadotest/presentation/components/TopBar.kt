package com.example.mercadotest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBarFull(
    showBackArrow: Boolean = false,
    onSearchBarClick: () -> Unit,
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(Color(0xFFFFEB3B))
            .padding(bottom = 4.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (showBackArrow) Arrangement.Start else Arrangement.End
        ) {
            if (showBackArrow)
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .size(28.dp)
                        .clickable { onBackClick() }
                )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .height(45.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .clickable { onSearchBarClick() },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = White,
                    unfocusedContainerColor = White,
                    focusedContainerColor = Red,
                    unfocusedPlaceholderColor = White,
                    disabledPlaceholderColor = White,
                    selectionColors = TextSelectionColors(
                        backgroundColor = White,
                        handleColor = White
                    )
                ),
                singleLine = true,
                enabled = false,
                readOnly = true,
                label = { Text("Buscar...", fontSize = 14.sp, color = LightGray) },
            )
            if (!showBackArrow) {
                Spacer(Modifier.width(8.dp))
                Icon(
                    Icons.Default.Settings,
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }
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