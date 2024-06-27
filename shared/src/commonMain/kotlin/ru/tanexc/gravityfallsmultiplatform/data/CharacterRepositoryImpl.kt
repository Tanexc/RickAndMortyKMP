package ru.tanexc.gravityfallsmultiplatform.data

import kotlinx.coroutines.flow.Flow
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character
import ru.tanexc.gravityfallsmultiplatform.domain.repository.CharacterRepository

class CharacterRepositoryImpl: CharacterRepository {
    override fun getCharcter(id: Long): Flow<Character> {
        TODO()
    }

    override fun getPage(offset: Int, limit: Int): Flow<List<Character>> {
        TODO("Not yet implemented")
    }
}