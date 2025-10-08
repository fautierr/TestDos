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
fun DetailScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = "Esta es la pantalla de detalle", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(20.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(onBack = {})
}