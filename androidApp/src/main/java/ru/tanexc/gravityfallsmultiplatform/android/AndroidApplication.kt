package ru.tanexc.gravityfallsmultiplatform.android

import android.app.Application
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.koin.androidContext
import ru.tanexc.gravityfallsmultiplatform.core.di.koinInit

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        koinInit {
            androidContext(this@AndroidApplication)
        }
    }
}