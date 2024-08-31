package ru.tanexc.rickandmortykmp.presentation.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.mp.KoinPlatform.getKoin
import ru.tanexc.rickandmortykmp.presentation.screen.catalog.CatalogScreen
import ru.tanexc.rickandmortykmp.presentation.ui.theme.AppTheme
import ru.tanexc.rickandmortykmp.presentation.ui.util.Screen

class GravityFallsAppMain {
    @Composable
    fun create() = GravityFallsApp()
}

@Composable
fun GravityFallsApp() {
    val navController = rememberNavController()
    val mainViewModel: MainViewModel by getKoin().inject()


    AppTheme {
        Scaffold { paddings ->
            NavHost(
                navController,
                startDestination = Screen.Catalog.name
            ) {
                composable(Screen.Catalog.name) {
                    CatalogScreen(Modifier.padding(paddings))
                }

                composable(Screen.Character.name) {

                }

            }
        }
    }
}