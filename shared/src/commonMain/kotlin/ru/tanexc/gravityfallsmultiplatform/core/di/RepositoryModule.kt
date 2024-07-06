package ru.tanexc.gravityfallsmultiplatform.core.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.tanexc.gravityfallsmultiplatform.data.CharacterRepositoryImpl
import ru.tanexc.gravityfallsmultiplatform.data.remote.api.CharacterApi
import ru.tanexc.gravityfallsmultiplatform.data.remote.api.CharacterApiImpl
import ru.tanexc.gravityfallsmultiplatform.domain.repository.CharacterRepository

val repositoryModule = module {

    singleOf(::CharacterApiImpl) bind CharacterApi::class
    singleOf(::CharacterRepositoryImpl) bind CharacterRepository::class
}