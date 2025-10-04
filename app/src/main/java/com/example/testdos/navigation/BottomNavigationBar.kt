package com.example.testdos.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(HomeGraph, ListGraph, ProfileGraph)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        items.forEach { graph ->
            val selected = currentDestination?.hierarchy?.any { it.route == graph::class.qualifiedName } == true

            val (filledIcon, outlinedIcon, label) = when (graph) {
                HomeGraph -> Triple(Icons.Filled.Home, Icons.Outlined.Home, "Inicio")
                ListGraph -> Triple(Icons.AutoMirrored.Filled.List,
                    Icons.AutoMirrored.Outlined.List, "Lista")
                ProfileGraph -> Triple(Icons.Filled.Person, Icons.Outlined.Person, "Perfil")
                else -> Triple(Icons.Filled.Home, Icons.Outlined.Home, "Otro")
            }

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (selected) filledIcon else outlinedIcon,
                        contentDescription = label
                    )
                },
                label = { Text(label) },
                selected = selected,
                onClick = {
                    navController.navigate(graph) {
                        popUpTo(navController.graph.id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

