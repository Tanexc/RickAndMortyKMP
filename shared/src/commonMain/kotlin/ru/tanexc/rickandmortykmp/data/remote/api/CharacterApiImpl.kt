package ru.tanexc.rickandmortykmp.data.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.tanexc.rickandmortykmp.core.BASE_URL
import ru.tanexc.rickandmortykmp.core.CHARACTER_ENDPOINT
import ru.tanexc.rickandmortykmp.domain.model.Character

class CharacterApiImpl(
    private val httpClient: HttpClient
) : CharacterApi {
    override suspend fun getById(id: Int): Character? {
        val data: Result<Character?> = runCatching {
            httpClient.get("$BASE_URL/$CHARACTER_ENDPOINT/$id").body<Character>()
        }
        return data.getOrNull()
    }

    override suspend fun getPage(page: Int): List<Character> {
        val data: List<Character> =
            httpClient.get("$BASE_URL/$CHARACTER_ENDPOINT?page=$page}").body<List<Character>>()
        return data
    }
}