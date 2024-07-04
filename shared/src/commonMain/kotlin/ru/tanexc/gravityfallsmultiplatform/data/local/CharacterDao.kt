package ru.tanexc.gravityfallsmultiplatform.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.tanexc.gravityfallsmultiplatform.core.REQUEST_PAGE_LIMIT

@Dao
interface CharacterDao {

    @Query("select * from characterentity where id = :id")
    suspend fun getById(id: Int): CharacterEntity?

    @Query("select * from characterentity limit :limit offset :offset")
    suspend fun get(offset: Int, limit: Int = REQUEST_PAGE_LIMIT): List<CharacterEntity>

    @Insert
    suspend fun insert(data: List<CharacterEntity>)

    @Query("delete from characterentity")
    suspend fun delete()
}