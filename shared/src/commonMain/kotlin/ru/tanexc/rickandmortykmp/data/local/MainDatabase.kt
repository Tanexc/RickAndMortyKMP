package ru.tanexc.rickandmortykmp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterDao
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterLocationDao
import ru.tanexc.rickandmortykmp.data.local.dao.CharacterOriginDao
import ru.tanexc.rickandmortykmp.data.local.dao.LocationDao
import ru.tanexc.rickandmortykmp.data.local.entity.main.CharacterEntity

@Database(
    entities=[CharacterEntity::class],
    version=1
)
abstract class MainDatabase: RoomDatabase() {
    abstract val characterDao: CharacterDao
    abstract val locationDao: LocationDao
    abstract val characterLocationDao: CharacterLocationDao
    abstract val characterOriginDao: CharacterOriginDao
}

fun getDatabase(
    builder: RoomDatabase.Builder<MainDatabase>
): MainDatabase = builder
    .setDriver(BundledSQLiteDriver())
    .setQueryCoroutineContext(Dispatchers.IO)
    .build()