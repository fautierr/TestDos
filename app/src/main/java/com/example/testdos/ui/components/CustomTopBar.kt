package com.example.testdos.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String,
    showBackButton: Boolean = false,
    onBack: (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .height(60.dp), // altura estándar de Material3
        title = {
            Text(
                text = title,
                // modifier = Modifier.padding(bottom = 10.dp) // espacio sutil abajo
            )
        },

        navigationIcon = {
            if (showBackButton && onBack != null) {
                IconButton(
                    onClick = onBack,
                    // modifier = Modifier.padding(bottom = 10.dp) // igual que el título
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver"
                    )
                }
            }
        },
        actions = {
            if (showBackButton) {
                Spacer(modifier = Modifier.width(48.dp))
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            // titleContentColor = MaterialTheme.colorScheme.onPrimary,
            // navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}
