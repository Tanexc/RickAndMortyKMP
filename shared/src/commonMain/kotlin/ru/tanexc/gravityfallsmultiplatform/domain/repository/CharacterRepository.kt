package ru.tanexc.gravityfallsmultiplatform.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.tanexc.gravityfallsmultiplatform.core.REQUEST_PAGE_LIMIT
import ru.tanexc.gravityfallsmultiplatform.domain.DataState
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character

interface CharacterRepository {
    fun getCharacter(id: Long): Flow<DataState<Character>>

    fun getPage(page: Int): Flow<DataState<List<Character>>>

    fun setCharacter(data: List<Character>)

    fun delete()

    fun setFavorite(id: Long)
}