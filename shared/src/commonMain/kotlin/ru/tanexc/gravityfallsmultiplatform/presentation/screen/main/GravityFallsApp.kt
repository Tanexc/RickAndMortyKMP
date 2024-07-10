package ru.tanexc.gravityfallsmultiplatform.presentation.screen.main

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import org.koin.mp.KoinPlatform.getKoin
import ru.tanexc.gravityfallsmultiplatform.core.getAsyncImageLoader
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.theme.AppTheme
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.imageTool.ComposeImage

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterial3Api::class)
@Composable
fun GravityFallsApp() {
    val navController = rememberNavController()

    val mainViewModel: MainViewModel by getKoin().inject()

    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }
    AppTheme {

        ComposeImage(
            "https://rickandmortyapi.com/api/character/avatar/182.jpeg",
            contentDescription = null,
            contentScale = ContentScale.Fit,
            onLoading = { progress ->
                CircularProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.size(32.dp)
                )
            },
            onError = {
                Icon(Icons.Default.ErrorOutline, null)
            },
            modifier = Modifier.size(240.dp, 160.dp)
        )

        /*Scaffold { paddings ->
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
        }*/
    }
}