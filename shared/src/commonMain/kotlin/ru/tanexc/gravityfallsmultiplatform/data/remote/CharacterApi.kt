package ru.tanexc.gravityfallsmultiplatform.data.remote

import ru.tanexc.gravityfallsmultiplatform.core.REQUEST_PAGE_LIMIT
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character

interface CharacterApi {
    fun getById(id: Int): Character?

    fun getPage(limit: Int = REQUEST_PAGE_LIMIT, offset: Int)
}