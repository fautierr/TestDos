package com.example.testdos.navigation

// import SetupStatusBar
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
// import androidx.compose.foundation.layout.padding
// import androidx.compose.material3.ExperimentalMaterial3Api
// import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
// import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

// import androidx.navigation.compose.rememberNavController
import com.example.testdos.ui.screens.DetailScreen
import com.example.testdos.ui.screens.HomeScreen
import com.example.testdos.ui.screens.ListScreen
import com.example.testdos.ui.screens.ProfileScreen
// import androidx.compose.material3.MaterialTheme

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost() {
    // SetupStatusBar()
    val navController = rememberNavController()
    val shouldShowBottomBar = shouldShowBottomBar(navController)

    Scaffold(
        // containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            if (shouldShowBottomBar) {
            BottomNavigationBar(navController = navController)
        } }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeGraph,
            // modifier = Modifier.padding(innerPadding)
            modifier = Modifier
                .padding(innerPadding)

        ) {
            // Grafo Home
            navigation<HomeGraph>(startDestination = Home) {
                composable<Home>(
                    enterTransition = { EnterTransition.None }, // Home no necesita animación cuando se muestra como raíz
                    exitTransition = { ExitTransition.None },  // ni cuando salís hacia otro root
                    popEnterTransition = { EnterTransition.None },
                    popExitTransition = { ExitTransition.None }
                ) {
                    HomeScreen(
                        onNavigate = { navController.navigate(Detail) }
                    )
                }

                composable<Detail>(
                    enterTransition = {
                        if (initialState.destination.route == Home::class.qualifiedName) {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(300)
                            )
                        } else null
                    },
                    popExitTransition = {
                        if (targetState.destination.route == Home::class.qualifiedName) {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(300)
                            )
                        } else null
                    }
                ) {
                    DetailScreen(onBack = { navController.popBackStack() })
                }

            }

            // Grafo Lista
            navigation<ListGraph>(startDestination = List) {
                composable<List>(
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    popEnterTransition = { EnterTransition.None },
                    popExitTransition = { ExitTransition.None }
                ) {
                    ListScreen()
                }
            }

            // Grafo Perfil
            navigation<ProfileGraph>(startDestination = Profile) {
                composable<Profile>(
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    popEnterTransition = { EnterTransition.None },
                    popExitTransition = { ExitTransition.None }
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}*/


/*@Composable
fun AppNavHost( navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = HomeGraph,
        // modifier = Modifier.padding(innerPadding)
        modifier = modifier

    ) {
        // Grafo Home
        navigation<HomeGraph>(startDestination = Home) {
            composable<Home>(
                enterTransition = { EnterTransition.None }, // Home no necesita animación cuando se muestra como raíz
                exitTransition = { ExitTransition.None },  // ni cuando salís hacia otro root
                popEnterTransition = { EnterTransition.None },
                popExitTransition = { ExitTransition.None }
            ) {
                HomeScreen(
                    onNavigate = { navController.navigate(Detail) }
                )
            }

            composable<Detail>(
                enterTransition = {
                    if (initialState.destination.route == Home::class.qualifiedName) {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(300)
                        )
                    } else null
                },
                popExitTransition = {
                    if (targetState.destination.route == Home::class.qualifiedName) {
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(300)
                        )
                    } else null
                }
            ) {
                DetailScreen(onBack = { navController.popBackStack() })
            }

        }

        // Grafo Lista
        navigation<ListGraph>(startDestination = List) {
            composable<List>(
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None },
                popEnterTransition = { EnterTransition.None },
                popExitTransition = { ExitTransition.None }
            ) {
                ListScreen()
            }
        }

        // Grafo Perfil
        navigation<ProfileGraph>(startDestination = Profile) {
            composable<Profile>(
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None },
                popEnterTransition = { EnterTransition.None },
                popExitTransition = { ExitTransition.None }
            ) {
                ProfileScreen()
            }
        }
    }
}*/

@Composable
fun AppNavHost( navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = HomeGraph,
        // modifier = Modifier.padding(innerPadding)
        modifier = modifier

    ) {
        // Grafo Home
        navigation<HomeGraph>(startDestination = Home) {
            composable<Home>{
                HomeScreen(
                    onNavigate = { navController.navigate(Profile) }
                )
            }

            composable<Detail>{
                DetailScreen(onBack = { navController.popBackStack() })
            }

        }

        // Grafo Lista
        navigation<ListGraph>(startDestination = List) {
            composable<List>{
                ListScreen()
            }
        }

        // Grafo Perfil
        navigation<ProfileGraph>(startDestination = Profile) {
            composable<Profile>{
                ProfileScreen()
            }
        }
    }
}


/*@Preview(showBackground = true)
@Composable
fun AppNavHostPreview() {
    AppNavHost()
}*/
