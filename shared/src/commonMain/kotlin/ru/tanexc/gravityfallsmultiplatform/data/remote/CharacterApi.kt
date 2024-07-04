package ru.tanexc.gravityfallsmultiplatform.data.remote

import ru.tanexc.gravityfallsmultiplatform.core.REQUEST_PAGE_LIMIT
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character

interface CharacterApi {
    suspend fun getById(id: Int): CharacterDto?

    suspend fun getPage(offset: Int, limit: Int = REQUEST_PAGE_LIMIT): List<CharacterDto>
}