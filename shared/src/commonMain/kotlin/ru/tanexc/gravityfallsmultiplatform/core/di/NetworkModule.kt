package ru.tanexc.gravityfallsmultiplatform.core.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.tanexc.gravityfallsmultiplatform.data.remote.api.CharacterApi
import ru.tanexc.gravityfallsmultiplatform.data.remote.api.CharacterApiImpl

val networkModule = module {
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
    singleOf(::CharacterApiImpl) bind CharacterApi::class
}