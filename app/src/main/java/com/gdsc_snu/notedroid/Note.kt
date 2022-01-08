package com.gdsc_snu.notedroid

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(val isImp: Boolean, val text: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}