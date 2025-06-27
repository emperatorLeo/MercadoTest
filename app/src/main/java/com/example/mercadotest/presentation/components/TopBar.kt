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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mercadotest.R

@Composable
fun TopBarFull(
    showBackArrow: Boolean = false,
    onSearchBarClick: () -> Unit,
    onBackClick: () -> Unit = {},
    mainColor: Color = Color(0xFF3483FA),
    onColorSelected: (Color) -> Unit ={}
) {
    var expanded by remember { mutableStateOf(false) }
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
                    contentDescription = stringResource(R.string.back_button_accessibility),
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
                    focusedContainerColor = mainColor,
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
                label = { Text(stringResource(R.string.search_placeholder), fontSize = 14.sp, color = LightGray) },
            )
            Spacer(Modifier.width(8.dp))
            if (!showBackArrow) {
                Box {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = stringResource(R.string.settings_icon_accessibility),
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { expanded = true }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Naranja") },
                            onClick = {
                                onColorSelected(Color(0xFFFF9800)) // Naranja
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Violeta") },
                            onClick = {
                                onColorSelected(Color(0xFF8E24AA)) // Violeta
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Verde") },
                            onClick = {
                                onColorSelected(Color(0xFF43A047)) // Verde
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Azul") },
                            onClick = {
                                onColorSelected(Color(0xFF3483FA)) // Azul
                                expanded = false
                            }
                        )
                    }
                }
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
                contentDescription = stringResource(R.string.location_icon_accessibility),
                modifier = Modifier.size(18.dp)
            )
            Text(stringResource(R.string.location_address), fontSize = 15.sp)
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}