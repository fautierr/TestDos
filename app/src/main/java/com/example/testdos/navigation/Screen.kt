package com.example.testdos.navigation

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Inicio")
    object Detail : Screen("detail", "Detalle")
}