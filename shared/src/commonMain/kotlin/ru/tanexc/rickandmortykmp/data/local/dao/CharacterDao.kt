package ru.tanexc.rickandmortykmp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.tanexc.rickandmortykmp.core.REQUEST_PAGE_LIMIT
import ru.tanexc.rickandmortykmp.data.local.entity.main.CharacterEntity
import ru.tanexc.rickandmortykmp.data.local.entity.main.CharacterWithLoc

@Dao
interface CharacterDao {

    @Query("select * from characterentity where id = :id")
    suspend fun getById(id: Int): CharacterWithLoc?

    @Query("select * from characterentity limit :limit offset :offset")
    suspend fun getAll(offset: Int, limit: Int = REQUEST_PAGE_LIMIT): List<CharacterWithLoc>

    @Insert
    suspend fun insert(data: List<CharacterEntity>): List<Long>

    @Query("delete from characterentity")
    suspend fun delete()
}