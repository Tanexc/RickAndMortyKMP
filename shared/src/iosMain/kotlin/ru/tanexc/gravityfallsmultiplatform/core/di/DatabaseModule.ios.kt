package ru.tanexc.gravityfallsmultiplatform.core.di

import org.koin.dsl.module
import ru.tanexc.gravityfallsmultiplatform.data.local.CharacterDao
import ru.tanexc.gravityfallsmultiplatform.data.local.MainDatabase
import ru.tanexc.gravityfallsmultiplatform.data.local.getDatabase
import ru.tanexc.gravityfallsmultiplatform.core.getDatabaseBuilder

actual val databaseModule = module {
    single { getDatabaseBuilder() }
    single<MainDatabase> { getDatabase(get()) }
    single<CharacterDao> { get<MainDatabase>().characterDao }
}