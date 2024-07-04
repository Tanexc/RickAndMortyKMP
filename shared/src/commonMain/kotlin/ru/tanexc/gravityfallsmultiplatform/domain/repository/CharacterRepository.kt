package ru.tanexc.gravityfallsmultiplatform.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.tanexc.gravityfallsmultiplatform.core.REQUEST_PAGE_LIMIT
import ru.tanexc.gravityfallsmultiplatform.domain.DataState
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character

interface CharacterRepository {
    fun getCharacter(id: Int): Flow<DataState<Character>>

    fun getPage(page: Int): Flow<DataState<List<Character>>>

    suspend fun setCharacter(data: List<Character>)

    suspend fun delete()

    suspend fun setFavorite(id: Long)
}