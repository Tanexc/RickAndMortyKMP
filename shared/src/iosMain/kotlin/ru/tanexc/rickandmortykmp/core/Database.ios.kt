package ru.tanexc.rickandmortykmp.core

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import ru.tanexc.rickandmortykmp.data.local.MainDatabase
import ru.tanexc.rickandmortykmp.data.local.instantiateImpl


fun getDatabaseBuilder(): RoomDatabase.Builder<MainDatabase> {
    val dbFilePath = NSHomeDirectory() + "/my_room.db"
    return Room.databaseBuilder<MainDatabase>(
        name = dbFilePath,
        factory =  { MainDatabase::class.instantiateImpl() }
    )
}
