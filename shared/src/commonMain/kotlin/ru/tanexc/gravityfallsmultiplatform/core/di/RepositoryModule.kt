package ru.tanexc.gravityfallsmultiplatform.core.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.tanexc.gravityfallsmultiplatform.data.CharacterRepositoryImpl
import ru.tanexc.gravityfallsmultiplatform.domain.repository.CharacterRepository

val repositoryModule = module {
    singleOf(::CharacterRepositoryImpl) bind CharacterRepository::class
}