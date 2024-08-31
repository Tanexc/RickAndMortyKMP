package ru.tanexc.rickandmortykmp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.tanexc.rickandmortykmp.domain.DataState
import ru.tanexc.rickandmortykmp.domain.model.Character

interface CharacterRepository {
    fun getCharacter(id: Int): Flow<DataState<Character>>

    fun getPage(page: Int): Flow<DataState<List<Character>>>

    suspend fun delete()

}