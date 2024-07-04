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
        runBlocking {
            flow {
                emit(1)
                delay(10)
                emit(2)
            }.collect { param ->
                launch {
                    delay(100)
                    println("processed $param")
                }
            }
        }
        koinInit {
            androidContext(this@AndroidApplication)
        }
    }
}