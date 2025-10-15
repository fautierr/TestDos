package com.example.testdos.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import com.example.testdos.ui.components.CustomTopBar
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val shouldShowBottomBar = shouldShowBottomBar(navController)
    var search by remember { mutableStateOf("") }
    Scaffold(
        // ... otros parámetros del Scaffold ...
        topBar = {
            /*CustomTopBar(
                title = "Transacciones",
                showBackButton = false,
                onBack = { *//* navigate back *//* },
                onSearchClick = { *//* acción buscar *//* },
                onNotificationsClick = { *//* acción notificaciones *//* }
            )*/

            CustomTopBar(
                searchQuery = search,
                onSearchQueryChange = { search = it },
                showBackButton = true,
                onBack = { /* acción back */ },
                onNotificationsClick = { /* acción notificaciones */ }
            )
        },
       /* bottomBar = {
            if (shouldShowBottomBar) {
                BottomNavigationBar(navController = navController)
            }
        }*/
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}