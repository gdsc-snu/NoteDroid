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

package com.gdsc_snu.notedroid.ui

import androidx.lifecycle.ViewModel
import com.gdsc_snu.notedroid.data.Note
import com.gdsc_snu.notedroid.db.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(
    val repository: NoteRepository
): ViewModel() {

    fun insert(note : Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(note)
    }

    fun delete(note : Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(note)
    }

    fun getAllNoteItems() = repository.getAllNoteItem()

    fun getAllImportantNoteItems() = repository.getAllImportantNotes()
}