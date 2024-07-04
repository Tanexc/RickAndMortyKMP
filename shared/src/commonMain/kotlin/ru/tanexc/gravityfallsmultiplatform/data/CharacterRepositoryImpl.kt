package ru.tanexc.gravityfallsmultiplatform.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.tanexc.gravityfallsmultiplatform.core.REQUEST_PAGE_LIMIT
import ru.tanexc.gravityfallsmultiplatform.data.local.CharacterDao
import ru.tanexc.gravityfallsmultiplatform.data.remote.CharacterApi
import ru.tanexc.gravityfallsmultiplatform.domain.DataState
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character
import ru.tanexc.gravityfallsmultiplatform.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val characterDao: CharacterDao,
    private val characterApi: CharacterApi
) : CharacterRepository {
    override fun getCharacter(id: Int): Flow<DataState<Character>> = flow {
        emit(DataState.Loading)
        characterDao.getById(id) ?: characterApi.getById(id)
            ?.let { emit(DataState.Success(it.asDomain())) }
        ?: emit(DataState.Error)
    }

    override fun getPage(page: Int): Flow<DataState<List<Character>>> = flow {
        emit(DataState.Loading)
        val offset = page * REQUEST_PAGE_LIMIT
        val data = characterDao.get(offset).map { it.asDomain() }
            .ifEmpty {
                characterApi.getPage(offset).map { it.asDomain() }
            }
        if (data.isEmpty()) {
            emit(DataState.Error)
        } else emit(DataState.Success(data))
    }

    override suspend fun setCharacter(data: List<Character>) {
        characterDao.insert(data.map { it.asLocalData() })
    }

    override suspend fun delete() {
        characterDao.delete()
    }

    override suspend fun setFavorite(id: Long) {}
}