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

package com.gdsc_snu.notedroid.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    var isImp: Boolean = false,
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_description")
    val text: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}