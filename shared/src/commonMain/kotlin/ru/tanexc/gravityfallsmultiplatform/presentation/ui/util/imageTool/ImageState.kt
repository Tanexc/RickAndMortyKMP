package ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.imageTool

import androidx.compose.ui.graphics.ImageBitmap

sealed class ImageState {
    class Loading(
        val progress: Float
    ) : ImageState()

    data object Failed : ImageState()

    data class Success(
        val imageBitmap: ImageBitmap
    ) : ImageState()
}