package ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.imageTool

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import org.koin.mp.KoinPlatform.getKoin
import java.io.File

actual fun ByteArray.toImageBitmap(): ImageBitmap =
    BitmapFactory.decodeByteArray(this, 0, size).asImageBitmap()

actual fun saveToCache(byteArray: ByteArray, url: String) {
    val context: Context by getKoin().inject()
    val cache = context.cacheDir
    val file = File(cache, url.replace("/", "###"))
    file.writeBytes(byteArray)
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
actual fun getFromCache(url: String): ByteArray? {
    val context: Context by getKoin().inject()
    return runCatching {
        context.openFileInput(url.replace("/", "###")).readAllBytes()
    }.getOrNull()
}