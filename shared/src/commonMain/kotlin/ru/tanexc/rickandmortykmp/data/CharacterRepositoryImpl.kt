package ru.tanexc.rickandmortykmp.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.tanexc.rickandmortykmp.core.REQUEST_PAGE_LIMIT
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterDao
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterLocationDao
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterOriginDao
import ru.tanexc.rickandmortykmp.data.local.dao.LocationDao
import ru.tanexc.rickandmortykmp.data.local.entity.supportive.CharacterLocation
import ru.tanexc.rickandmortykmp.data.local.entity.supportive.CharacterOrigin
import ru.tanexc.rickandmortykmp.data.remote.api.CharacterApi
import ru.tanexc.rickandmortykmp.domain.DataState
import ru.tanexc.rickandmortykmp.domain.model.Character
import ru.tanexc.rickandmortykmp.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val characterDao: CharacterDao,
    private val characterLocationDao: CharacterLocationDao,
    private val characterOriginDao: CharacterOriginDao,
    private val locationDao: LocationDao,
    private val characterApi: CharacterApi
) : CharacterRepository {
    override fun getCharacter(id: Int): Flow<DataState<Character>> = flow {
        emit(DataState.Loading)
        characterDao.getById(id) ?: characterApi.getById(id)
            ?.let {
                val locId = locationDao.insert(it.location.asDataEntity())
                val oriId = locationDao.insert(it.origin.asDataEntity())
                characterLocationDao.insert(CharacterLocation(it.id, locId))
                characterOriginDao.insert(CharacterOrigin(it.id, oriId))
                emit(DataState.Success(it))
            }
        ?: emit(DataState.Error)
    }

    override fun getPage(page: Int): Flow<DataState<List<Character>>> = flow {
        emit(DataState.Loading)
        val offset = page * REQUEST_PAGE_LIMIT
        val data = characterDao.getAll(offset).map { it.asDomain() }
            .ifEmpty {
                val data = characterApi.getPage(page)
                data.forEach {
                    val locId = locationDao.insert(it.location.asDataEntity())
                    val oriId = locationDao.insert(it.origin.asDataEntity())
                    characterLocationDao.insert(CharacterLocation(it.id, locId))
                    characterOriginDao.insert(CharacterOrigin(it.id, oriId))
                }
                characterDao.insert(data.map { it.asDataEntity() })
                data
            }
        if (data.isEmpty()) {
            emit(DataState.Error)
        } else emit(DataState.Success(data))
    }

    override suspend fun delete() {
        characterDao.delete()
    }
}