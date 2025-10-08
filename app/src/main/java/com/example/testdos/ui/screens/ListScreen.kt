package com.example.testdos.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.testdos.ui.components.CustomTopBar
import com.example.testdos.ui.viewmodel.ListViewModel
import com.example.testdos.data.remote.model.CharacterDto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(viewModel: ListViewModel = viewModel()) {
    val characters by viewModel.characters.collectAsState()
    ListScreenContent(characters)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreenContent(characters: List<CharacterDto>) {
    LazyColumn(
        modifier = Modifier
            // .padding(innerPadding)
            .padding(16.dp)
    ) {
        items(characters) { character ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface // sin color de fondo
                    // containerColor = Color.Transparent
                ),

                border = BorderStroke(
                    width = 0.1.dp,
                    color = MaterialTheme.colorScheme.outline
                ),
                /* elevation = CardDefaults.cardElevation(
                     defaultElevation = 0.1.dp, // aumenta la “sombra”
                 )*/
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    /* Image(
                         painter = rememberAsyncImagePainter(character.image),
                         contentDescription = character.name,
                         // modifier = Modifier.size(64.dp)
                         modifier = Modifier
                             .height(120.dp)          // más alta
                             .aspectRatio(1f)         // cuadrada
                             .clip(MaterialTheme.shapes.medium)
                     )*/
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            character.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            character.status,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    val sample = listOf(
        CharacterDto(1, "Rick Sanchez", "Alive", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
        CharacterDto(2, "Morty Smith", "unknown", "https://rickandmortyapi.com/api/character/avatar/2.jpeg")
    )
    ListScreenContent(sample)
}
