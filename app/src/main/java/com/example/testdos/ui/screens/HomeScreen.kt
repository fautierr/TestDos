package com.example.testdos.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.testdos.ui.components.CustomTopBar
import com.example.testdos.ui.theme.extendedColors
import com.example.testdos.R
/*@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    Scaffold(
        topBar = { CustomTopBar(title = "Inicio") },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { *//* acción *//* },
               *//* containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.background,*//*
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                    hoveredElevation = 0.dp
                )
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Item 1: Ventas de hoy
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Ventas de hoy",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$1890",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.extendedColors.medium
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_upward),
                            contentDescription = null,
                            tint = MaterialTheme.extendedColors.success
                        )
                    }
                }
            }

            // Item 2: Productos vendidos
            HorizontalDivider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.surface
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Productos vendidos",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "23",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.extendedColors.medium
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_upward),
                            contentDescription = null,
                            tint = MaterialTheme.extendedColors.success
                        )
                    }
                }
            }

            // Item 3: Control de stock
            HorizontalDivider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.surface
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Control de stock",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "2 producto(s) necesitan reposición",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.extendedColors.medium
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_downward),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de navegación
            Button(
                onClick = onNavigate,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ),
                border = BorderStroke(0.1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f))
            ) {
                Text("Ir al detalle")
            }
        }
    }
}*/


/*
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigate = {})
}*/

@Composable
fun HomeInfoCard(
    title: String,
    value: String,
    icon: Int,
    iconTint: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.extendedColors.medium
                )
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = iconTint
                )
            }
        }
    }
}

@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // --- Item 1: Ventas de hoy ---
        HomeInfoCard(
            title = "Ventas de hoy",
            value = "$1890",
            icon = R.drawable.arrow_upward,
            iconTint = MaterialTheme.extendedColors.success
        )

        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.surface
        )

        // --- Item 2: Productos vendidos ---
        HomeInfoCard(
            title = "Productos vendidos",
            value = "23",
            icon = R.drawable.arrow_upward,
            iconTint = MaterialTheme.extendedColors.success
        )

        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.surface
        )

        // --- Item 3: Control de stock ---
        HomeInfoCard(
            title = "Control de stock",
            value = "2 producto(s) necesitan reposición",
            icon = R.drawable.arrow_downward,
            iconTint = MaterialTheme.colorScheme.error
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- Botón de navegación ---
        Button(
            onClick = onNavigate,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            border = BorderStroke(0.1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f))
        ) {
            Text("Ir al detalle")
        }
    }
}
