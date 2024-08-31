package ru.tanexc.rickandmortykmp.data.remote.api

import ru.tanexc.rickandmortykmp.core.REQUEST_PAGE_LIMIT
import ru.tanexc.rickandmortykmp.domain.model.Character

interface CharacterApi {
    suspend fun getById(id: Int): Character?

    suspend fun getPage(page: Int): List<Character>
}