package ru.tanexc.gravityfallsmultiplatform.data.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import ru.tanexc.gravityfallsmultiplatform.core.BASE_URL
import ru.tanexc.gravityfallsmultiplatform.core.CHARACTER_ENDPOINT
import ru.tanexc.gravityfallsmultiplatform.data.remote.dto.CharacterDto

class CharacterApiImpl(
    private val httpClient: HttpClient
) : CharacterApi {
    override suspend fun getById(id: Int): CharacterDto? {
        val data: Result<CharacterDto?> = runCatching {
            httpClient.get("$BASE_URL/$CHARACTER_ENDPOINT/$id").body<CharacterDto>()
        }
        return data.getOrNull()
    }

    override suspend fun getPage(offset: Int, limit: Int): List<CharacterDto> {
        val data: List<CharacterDto> =
            httpClient.get("$BASE_URL/$CHARACTER_ENDPOINT?take=$limit&skip=$offset").body<List<CharacterDto>>()
        return data
    }
}