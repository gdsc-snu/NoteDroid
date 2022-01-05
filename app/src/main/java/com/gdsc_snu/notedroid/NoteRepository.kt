package com.gdsc_snu.notedroid

import androidx.lifecycle.LiveData

class NoteRepository(val noteDao: NoteDao) {

    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    val allImportantNotes: LiveData<List<Note>> = noteDao.getAllImportantNotes()

}