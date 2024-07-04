package ru.tanexc.gravityfallsmultiplatform.presentation.screen.catalog.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.theme.AppTypography


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterCard(
    character: Character
) {
    val imageState: MutableState<AsyncImagePainter.State> =
        remember { mutableStateOf(AsyncImagePainter.State.Empty) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.secondary.copy(0.2f),
                RoundedCornerShape(16.dp)
            )
    ) {
        Box(Modifier.fillMaxWidth(0.4f).weight(1f)) {
            AsyncImage(
                model = character.image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)),
                onState = { imageState.value = it }
            )
            when (imageState.value) {
                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                is AsyncImagePainter.State.Error -> {
                    Icon(
                        imageVector = Icons.Default.ErrorOutline,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp).padding(0.dp, 16.dp, 0.dp, 8.dp).align(
                            Alignment.Center)
                    )
                }

                else -> {}
            }
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                character.name,
                style = AppTypography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.basicMarquee()
            )
            Text(character.quote)
        }


    }
}