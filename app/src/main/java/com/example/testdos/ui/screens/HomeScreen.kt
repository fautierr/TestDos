package com.example.testdos.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.testdos.ui.components.CustomTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    Scaffold(
        // modifier = Modifier.background(MaterialTheme.colorScheme.primary),
        topBar = {
            CustomTopBar(title = "Inicio")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(text = "Bienvenido a la Home", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = onNavigate) {
                Text("Ir al detalle")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigate = {})
}