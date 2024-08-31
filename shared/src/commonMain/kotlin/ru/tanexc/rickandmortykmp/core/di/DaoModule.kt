package ru.tanexc.rickandmortykmp.core.di

import org.koin.dsl.module
import ru.tanexc.rickandmortykmp.data.local.MainDatabase
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterDao
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterLocationDao
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterOriginDao
import ru.tanexc.rickandmortykmp.data.local.dao.LocationDao

val daoModule = module {
    single<CharacterDao> { get<MainDatabase>().characterDao }
    single<CharacterLocationDao> { get<MainDatabase>().characterLocationDao }
    single<CharacterOriginDao> { get<MainDatabase>().characterOriginDao }
    single<LocationDao> { get<MainDatabase>().locationDao }
}