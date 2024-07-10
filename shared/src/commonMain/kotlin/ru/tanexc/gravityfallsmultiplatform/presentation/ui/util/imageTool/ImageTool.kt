package ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.imageTool

import androidx.compose.ui.graphics.ImageBitmap
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.onDownload
import io.ktor.client.request.get

class ImageTool {
    private val httpClient = HttpClient()

    suspend fun loadImage(
        url: String,
        collector: (suspend (received: Long, total: Long) -> Unit)? = null
    ): ImageBitmap {
        var data: ByteArray? = getFromCache(url)
        if (data != null) {
            collector?.let { it(1, 1) }
            return data.toImageBitmap()
        } else {
            val response = httpClient.get(url) {
                onDownload(collector)
            }
            data = response.body<ByteArray>()
            saveToCache(data, url)
            return data.toImageBitmap()
        }
    }
}
