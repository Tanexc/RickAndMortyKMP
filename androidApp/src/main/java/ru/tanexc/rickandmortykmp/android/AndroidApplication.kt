package ru.tanexc.rickandmortykmp.android

import android.app.Application
import org.koin.android.ext.koin.androidContext
import ru.tanexc.rickandmortykmp.core.di.koinInit

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        koinInit {
            androidContext(this@AndroidApplication)
        }
    }
}