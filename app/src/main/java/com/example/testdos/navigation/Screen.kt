package com.example.testdos.navigation

import kotlinx.serialization.Serializable

// Rutas principales (grafos anidados)
@Serializable object HomeGraph
@Serializable object ListGraph
@Serializable object ProfileGraph

// Rutas internas de cada grafo
@Serializable object Home
@Serializable object Detail
@Serializable object List
@Serializable object Profile

