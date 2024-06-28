package ru.tanexc.gravityfallsmultiplatform.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.tanexc.gravityfallsmultiplatform.core.BASE_URL
import ru.tanexc.gravityfallsmultiplatform.core.CHARACTER_ENDPOINT
import ru.tanexc.gravityfallsmultiplatform.core.REQUEST_PAGE_LIMIT

class CharacterApiImpl(
    private val httpClient: HttpClient
) : CharacterApi {
    override suspend fun getById(id: Int): CharacterDto? {
        val data: Result<CharacterDto?> = runCatching {
            httpClient.get("$BASE_URL/$CHARACTER_ENDPOINT/$id").body<CharacterDto>()
        }
        return data.getOrNull()
    }

    override suspend fun getPage(page: Int): List<CharacterDto> {
        val take = REQUEST_PAGE_LIMIT
        val skip = page * take

        val data: Result<List<CharacterDto>> = runCatching {
            httpClient.get("$BASE_URL/$CHARACTER_ENDPOINT?take=$take&skip=$skip").body<List<CharacterDto>>()
        }
        return data.getOrElse { emptyList() }
    }
}