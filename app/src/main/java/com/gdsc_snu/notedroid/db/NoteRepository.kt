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

import com.gdsc_snu.notedroid.data.Note

class NoteRepository(
    private val db: NoteDatabase
) {
    suspend fun insert(note : Note) = db.getNoteDao().insert(note)

    suspend fun delete(note : Note) = db.getNoteDao().delete(note)

    fun getAllNoteItem() = db.getNoteDao().getAllNotes()

    fun getAllImportantNotes() = db.getNoteDao().getAllImportantNotes()
}