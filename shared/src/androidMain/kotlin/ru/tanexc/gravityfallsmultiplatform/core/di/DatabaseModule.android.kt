package ru.tanexc.gravityfallsmultiplatform.core.di

import org.koin.dsl.module
import ru.tanexc.gravityfallsmultiplatform.data.local.getDatabase

actual val databaseModule = module {
    single { getDatabase(get()) }
}