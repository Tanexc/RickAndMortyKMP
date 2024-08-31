package ru.tanexc.rickandmortykmp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.tanexc.rickandmortykmp.data.local.entity.main.LocationEntity
import ru.tanexc.rickandmortykmp.domain.model.Location

@Dao
interface LocationDao {

    @Query("select * from loacationentity limit :limit offset :offset")
    suspend fun getAll(limit: Int, offset: Int): List<LocationEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data: LocationEntity): Long

    @Query("delete from locationentity where locId = :id")
    suspend fun deleteById(id: Long)
}