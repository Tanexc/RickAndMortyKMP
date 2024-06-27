package ru.tanexc.gravityfallsmultiplatform.android

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import ru.tanexc.gravityfallsmultiplatform.core.di.databaseBuilderModule
import ru.tanexc.gravityfallsmultiplatform.core.di.databaseModule
import ru.tanexc.gravityfallsmultiplatform.core.di.koinInit

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        koinInit {
            androidContext(this@AndroidApplication)
        }
    }
}