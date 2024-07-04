package ru.tanexc.gravityfallsmultiplatform.presentation.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.mp.KoinPlatform.getKoin
import ru.tanexc.gravityfallsmultiplatform.core.getAsyncImageLoader
import ru.tanexc.gravityfallsmultiplatform.presentation.screen.catalog.CatalogScreen
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.Screen
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.theme.AppTheme

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterial3Api::class)
@Composable
fun GravityFallsApp() {
    val navController = rememberNavController()

    val mainViewModel: MainViewModel by getKoin().inject()

    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }
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