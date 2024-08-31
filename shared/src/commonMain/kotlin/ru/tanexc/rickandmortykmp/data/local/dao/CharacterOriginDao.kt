package ru.tanexc.rickandmortykmp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.tanexc.rickandmortykmp.data.local.entity.supportive.CharacterLocation
import ru.tanexc.rickandmortykmp.data.local.entity.supportive.CharacterOrigin

@Dao
interface CharacterOriginDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: CharacterOrigin)

    @Query("delete from characterorigin where charId = :id")
    suspend fun delete(id: Long)
}