package ru.tanexc.gravityfallsmultiplatform.presentation.screen.catalog.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterCard(
    character: Character
) {
    Box(Modifier.fillMaxWidth().height(320.dp)) {
        SubcomposeAsyncImage(
            modifier = Modifier.fillMaxWidth(0.4f).fillMaxHeight(),
            model = character.image,
            contentScale = ContentScale.FillHeight,
            contentDescription = null
        ) {
            val imageState = painter.state.collectAsState()
            when (imageState.value) {
                is AsyncImagePainter.State.Loading ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(8.dp)
                        )
                    }

                is AsyncImagePainter.State.Success ->
                    SubcomposeAsyncImageContent(
                        modifier = Modifier
                            .align(Alignment.Center).fillMaxSize(),
                        contentScale = ContentScale.FillHeight
                    )

                else ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.Error,
                            null,
                        )

                        Text("Error")

                    }
            }
        }
    }
    /*Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp)
            .background(
                MaterialTheme.colorScheme.secondary.copy(0.2f),
                RoundedCornerShape(16.dp)
            )
    ) {

        SubcomposeAsyncImage(
            modifier = Modifier.fillMaxWidth(0.4f).fillMaxHeight(),
            model = character.image,
            contentScale = ContentScale.FillHeight,
            contentDescription = null
        ) {
            val imageState = painter.state.collectAsState()
            when (imageState.value) {
                is AsyncImagePainter.State.Loading ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(8.dp)
                        )
                    }

                is AsyncImagePainter.State.Success ->
                    SubcomposeAsyncImageContent(
                        modifier = Modifier
                            .align(Alignment.Center).fillMaxSize(),
                        contentScale = ContentScale.FillHeight
                    )

                else ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.Error,
                            null,
                        )

                        Text("Error")

                    }
            }
        }
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(
                character.name,
                style = AppTypography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.basicMarquee()
            )
            Text(character.quote)
        }
    }*/
}