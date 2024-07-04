package ru.tanexc.gravityfallsmultiplatform.core.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.tanexc.gravityfallsmultiplatform.core.getDatabaseBuilder
import ru.tanexc.gravityfallsmultiplatform.data.local.getDatabase
import ru.tanexc.gravityfallsmultiplatform.data.local.CharacterDao
import ru.tanexc.gravityfallsmultiplatform.data.local.CharacterDao_Impl
import ru.tanexc.gravityfallsmultiplatform.data.local.MainDatabase


actual val databaseModule = module {
    single { getDatabaseBuilder(get()) }
    single<MainDatabase> { getDatabase(get()) }
    single<CharacterDao> { get<MainDatabase>().characterDao }
}