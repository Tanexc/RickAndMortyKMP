package ru.tanexc.gravityfallsmultiplatform.core.di

import org.koin.core.module.Module
import org.koin.core.scope.get
import org.koin.dsl.module
import ru.tanexc.gravityfallsmultiplatform.core.getDatabaseBuilder

actual val databaseBuilderModule = module {
    single { getDatabaseBuilder(get()) }
}