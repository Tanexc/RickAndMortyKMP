package ru.tanexc.gravityfallsmultiplatform.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao {

    @Insert
    suspend fun insert(data: List<CharacterEntity>)

    @Query("delete from characterentity")
    suspend fun delete()
}