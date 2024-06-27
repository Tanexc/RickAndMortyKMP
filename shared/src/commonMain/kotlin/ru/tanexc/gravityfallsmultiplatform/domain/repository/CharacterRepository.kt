package ru.tanexc.gravityfallsmultiplatform.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.tanexc.gravityfallsmultiplatform.core.REQUEST_PAGE_LIMIT
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character

interface CharacterRepository {
    fun getCharcter(id: Long): Flow<Character>

    fun getPage(offset: Int, limit: Int = REQUEST_PAGE_LIMIT): Flow<List<Character>>
}