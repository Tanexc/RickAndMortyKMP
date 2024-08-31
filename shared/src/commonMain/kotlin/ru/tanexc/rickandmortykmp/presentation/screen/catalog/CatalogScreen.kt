package ru.tanexc.rickandmortykmp.presentation.screen.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.mp.KoinPlatform.getKoin
import ru.tanexc.rickandmortykmp.presentation.screen.catalog.components.CharacterCard
import ru.tanexc.rickandmortykmp.presentation.ui.util.UIState

@Composable
fun CatalogScreen(modifier: Modifier) {
    val viewModel: CatalogViewModel by getKoin().inject()
    val state = viewModel.state.collectAsState()
    Box(modifier.fillMaxSize()) {
        when (state.value) {
            UIState.Loading -> {
                CircularProgressIndicator(
                    Modifier
                        .size(32.dp)
                        .align(Alignment.Center)
                )
            }
            UIState.Error -> {
                Column(Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(0.5f)
                    .background(MaterialTheme.colorScheme.background.copy(0.3f), RoundedCornerShape(22.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.ErrorOutline,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp).padding(0.dp, 16.dp, 0.dp, 8.dp)
                    )
                    Text(
                        "Error while loading",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(0.dp, 8.dp, 0.dp, 16.dp)
                    )
                }
            }
            else -> {
                LazyColumn {
                    items(items = viewModel.data) { data ->
                        CharacterCard(data)
                    }
                    item {
                        LaunchedEffect(true) {
                            viewModel.nextPage()
                        }
                    }
                }
            }
        }
    }

}