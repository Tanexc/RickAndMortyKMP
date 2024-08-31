package ru.tanexc.rickandmortykmp.core.di

import org.koin.dsl.module
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterDao
import ru.tanexc.rickandmortykmp.data.local.MainDatabase
import ru.tanexc.rickandmortykmp.data.local.getDatabase
import ru.tanexc.rickandmortykmp.core.getDatabaseBuilder

actual val databaseModule = module {
    single { getDatabaseBuilder() }
    single<MainDatabase> { getDatabase(get()) }
}