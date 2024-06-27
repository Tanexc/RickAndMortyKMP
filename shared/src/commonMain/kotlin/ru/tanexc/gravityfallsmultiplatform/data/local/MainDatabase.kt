package ru.tanexc.gravityfallsmultiplatform.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

@Database(
    entities=[CharacterEntity::class],
    version=1
)
abstract class MainDatabase: RoomDatabase() {
    abstract val characterDao: CharacterDao
}

fun getDatabase(
    builder: RoomDatabase.Builder<MainDatabase>
): MainDatabase = builder
    .setDriver(BundledSQLiteDriver())
    .build()