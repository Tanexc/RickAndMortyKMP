package ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.imageTool

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.skia.Image
import platform.Foundation.NSCache
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSKeyedArchiver

actual fun ByteArray.toImageBitmap(): ImageBitmap =
    Image.makeFromEncoded(this).toComposeImageBitmap()


actual fun saveToCache(byteArray: ByteArray, url: String) {
    val cache = NSCache()
    cache.setObject(byteArray, url)
}

actual fun getFromCache(url: String): ByteArray? {
    val cache = NSCache()
    return cache.objectForKey(url) as ByteArray
}