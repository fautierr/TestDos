package com.example.testdos.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(HomeGraph, ListGraph, ProfileGraph)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background // <-- acá le decís que use el surface
    ) {
        items.forEach { graph ->
            val (icon, label) = when (graph) {
                HomeGraph -> Icons.Default.Home to "Inicio"
                ListGraph -> Icons.AutoMirrored.Filled.List to "Lista"
                ProfileGraph -> Icons.Default.Person to "Perfil"
                else -> Icons.Default.Home to "Otro"
            }

            NavigationBarItem(
                icon = { androidx.compose.material3.Icon(icon, contentDescription = null) },
                label = { Text(label) },
                selected = currentDestination?.hierarchy?.any { it.route == graph::class.qualifiedName } == true,
                onClick = {
                    navController.navigate(graph) {
                        popUpTo(navController.graph.id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    /*navController.navigate(graph) {
                       popUpTo(navController.graph.startDestinationId) {
                           inclusive = false
                       }
                       launchSingleTop = true
                       restoreState = false // 👈 con este fragmento se puede volver siempre a la vista principal
                   }*/
                },
                colors = NavigationBarItemDefaults.colors(
                    // selectedIconColor = MaterialTheme.colorScheme.onSurface,
                    // unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                    // selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    // unselectedTextColor = MaterialTheme.colorScheme.onSurface,
                    indicatorColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    }
}
