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

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.gdsc_snu.notedroid.R
import com.gdsc_snu.notedroid.data.Note
import kotlinx.android.synthetic.main.add_note.*

class AddNoteItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)

        idBtnAdd.setOnClickListener {
            val title = TitleAddEt.text.toString()
            val text = NoteAddEt.text.toString()

            if(title.isEmpty() || text.isEmpty()) {
                Toast.makeText(context, "Please enter all of the required information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = Note(title = title, text = text)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        idBtnCancel.setOnClickListener {
            cancel()
        }
    }
}