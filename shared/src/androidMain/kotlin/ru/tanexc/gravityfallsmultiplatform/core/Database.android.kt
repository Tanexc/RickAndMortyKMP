package ru.tanexc.gravityfallsmultiplatform.core

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import ru.tanexc.gravityfallsmultiplatform.data.local.MainDatabase
import ru.tanexc.gravityfallsmultiplatform.data.local.instantiateImpl

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<MainDatabase> =
    Room.databaseBuilder<MainDatabase>(
        context = context,
        name = context.getDatabasePath("main_database.db").absolutePath,
    )