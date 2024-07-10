package ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.imageTool

import androidx.compose.ui.graphics.ImageBitmap

expect fun ByteArray.toImageBitmap(): ImageBitmap

expect fun saveToCache(byteArray: ByteArray, url: String)

expect fun getFromCache(url: String): ByteArray?