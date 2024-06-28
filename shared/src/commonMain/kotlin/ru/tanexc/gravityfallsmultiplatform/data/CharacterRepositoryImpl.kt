package ru.tanexc.gravityfallsmultiplatform.data

import kotlinx.coroutines.flow.Flow
import ru.tanexc.gravityfallsmultiplatform.data.local.CharacterDao
import ru.tanexc.gravityfallsmultiplatform.data.remote.CharacterApi
import ru.tanexc.gravityfallsmultiplatform.domain.DataState
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character
import ru.tanexc.gravityfallsmultiplatform.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val characterDao: CharacterDao,
    private val characterApi: CharacterApi
): CharacterRepository {
    override fun getCharacter(id: Long): Flow<DataState<Character>> {
        TODO("Not yet implemented")
    }

    override fun getPage(page: Int): Flow<DataState<List<Character>>> {
        TODO("Not yet implemented")
    }

    override fun setCharacter(data: List<Character>) {
        TODO("Not yet implemented")
    }

    override fun delete() {
        TODO("Not yet implemented")
    }

    override fun setFavorite(id: Long) {
        TODO("Not yet implemented")
    }
}