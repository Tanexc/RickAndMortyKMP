package ru.tanexc.gravityfallsmultiplatform.core

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import ru.tanexc.gravityfallsmultiplatform.data.local.MainDatabase
import ru.tanexc.gravityfallsmultiplatform.data.local.instantiateImpl

fun getDatabaseBuilder(): RoomDatabase.Builder<MainDatabase> {
    val dbFilePath = NSHomeDirectory() + "/my_room.db"
    return Room.databaseBuilder<MainDatabase>(
        name = dbFilePath,
        factory =  { MainDatabase::class.instantiateImpl() }
    )
}