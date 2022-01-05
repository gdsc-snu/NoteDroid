package com.gdsc_snu.notedroid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<Note>>

    val allImportantNotes: LiveData<List<Note>>

    init {
        val dao = NoteDatabase.getDatabase(application).noteDao()
        val repository = NoteRepository(dao)
        allNotes = repository.allNotes
        allImportantNotes = repository.allImportantNotes
    }
}