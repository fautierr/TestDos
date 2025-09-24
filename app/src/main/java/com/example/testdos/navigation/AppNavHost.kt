package com.example.testdos.navigation

import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.rememberNavController
import com.example.testdos.ui.screens.DetailScreen
import com.example.testdos.ui.screens.HomeScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    Scaffold(
        // topBar = { MyAppTopBar("Mi App Compose") },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(onNavigate = { navController.navigate(Screen.Detail.route) })
            }
            composable(Screen.Detail.route) {
                DetailScreen(onBack = { navController.popBackStack() })
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppNavHostPreview() {
    AppNavHost()
}
