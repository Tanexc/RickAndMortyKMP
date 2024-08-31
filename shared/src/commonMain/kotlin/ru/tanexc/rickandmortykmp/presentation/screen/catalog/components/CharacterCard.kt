package ru.tanexc.rickandmortykmp.presentation.screen.catalog.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tanexc.imagetool.widgets.ComposeImage
import ru.tanexc.rickandmortykmp.domain.model.Character
import ru.tanexc.rickandmortykmp.presentation.ui.theme.AppTypography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterCard(
    character: Character
) {
    Box(Modifier.fillMaxWidth().height(320.dp)) {
        ComposeImage(
            model = character.image,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            onLoading = { progress ->
                CircularProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.size(32.dp).align(Alignment.Center)
                )
            },
            onError = {
                Icon(Icons.Default.ErrorOutline, null, Modifier.align(Alignment.Center))
            },
            modifier = Modifier.matchParentSize().fillMaxWidth(0.4f)
        )
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
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