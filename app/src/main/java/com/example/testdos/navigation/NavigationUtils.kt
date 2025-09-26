package com.example.testdos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun shouldShowBottomBar(navController: NavController): Boolean {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // 👇 pantallas donde NO queremos mostrar el bottom bar
    val hideBottomBarRoutes = listOf(
        Detail::class.qualifiedName,
        // AddProduct::class.qualifiedName
    )

    return currentDestination?.route !in hideBottomBarRoutes
}