/*
 * Copyright (C) 2022 Google Developer Student Clubs SNU
 *
 * Licensed under the BSD 3-Clause "New" or "Revised" License;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://opensource.org/licenses/BSD-3-Clause
 *
 *  A permissive license similar to the BSD 2-Clause License, but with a 3rd clause
 *  that prohibits others from using the name of the project or its contributors to
 *  to promote derived products without written consent.
 *
 */

package com.gdsc_snu.notedroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gdsc_snu.notedroid.data.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase(){

    abstract fun getNoteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: createDatabase(context).also { INSTANCE = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "notes_database"
            ).build()
    }
}