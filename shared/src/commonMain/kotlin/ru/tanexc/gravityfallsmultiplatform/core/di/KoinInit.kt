package ru.tanexc.gravityfallsmultiplatform.core.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun koinInit(declaration: KoinApplication.() -> Unit = {}) {
    startKoin {
        declaration()
        modules(
            databaseBuilderModule,
            databaseModule
        )
    }
}