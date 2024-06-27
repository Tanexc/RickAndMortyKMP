package ru.tanexc.gravityfallsmultiplatform.presentation.screen.main

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.Screen
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.theme.AppTheme

@Composable
fun GravityFallsApp() {
    val navController = rememberNavController()
    AppTheme {
        Scaffold(
            bottomBar = {
                BottomAppBar {

                }
            }
        ) {
            NavHost(
                navController,
                startDestination = Screen.Catalog.name
            ) {
                composable(Screen.Catalog.name) {

                }

                composable(Screen.Character.name) {

                }

            }
        }
    }
}