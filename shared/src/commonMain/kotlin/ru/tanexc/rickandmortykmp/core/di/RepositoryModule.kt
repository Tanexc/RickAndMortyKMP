package ru.tanexc.rickandmortykmp.core.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.tanexc.rickandmortykmp.data.CharacterRepositoryImpl
import ru.tanexc.rickandmortykmp.data.remote.api.CharacterApi
import ru.tanexc.rickandmortykmp.data.remote.api.CharacterApiImpl
import ru.tanexc.rickandmortykmp.domain.repository.CharacterRepository

val repositoryModule = module {
    singleOf(::CharacterRepositoryImpl) bind CharacterRepository::class
}