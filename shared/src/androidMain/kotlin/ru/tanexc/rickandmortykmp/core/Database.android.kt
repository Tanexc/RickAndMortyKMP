package ru.tanexc.rickandmortykmp.core

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.tanexc.rickandmortykmp.data.local.MainDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<MainDatabase> =
    Room.databaseBuilder<MainDatabase>(
        context = context,
        name = context.getDatabasePath("main_database.db").absolutePath,
    )