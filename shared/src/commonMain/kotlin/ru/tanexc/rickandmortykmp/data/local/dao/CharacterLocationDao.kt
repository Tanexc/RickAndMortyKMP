package ru.tanexc.rickandmortykmp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.tanexc.rickandmortykmp.data.local.entity.supportive.CharacterLocation

@Dao
interface CharacterLocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: CharacterLocation)

    @Query("delete from characterlocation where charId = :id")
    suspend fun delete(id: Long)
}