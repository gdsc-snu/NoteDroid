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

package com.gdsc_snu.notedroid

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdsc_snu.notedroid.db.NoteDatabase
import com.gdsc_snu.notedroid.db.NoteRepository
import com.gdsc_snu.notedroid.recycler_view.ImportantNoteItemAdapter
import com.gdsc_snu.notedroid.ui.NoteViewModel
import com.gdsc_snu.notedroid.ui.NoteViewModelFactory
import kotlinx.android.synthetic.main.fragment_important_note.*

class ImportantNoteFragment : Fragment(R.layout.fragment_important_note) {

    private lateinit var factory: NoteViewModelFactory
    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = NoteDatabase(requireContext())
        val repository = NoteRepository(db)
        factory = NoteViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)

        val adapter = ImportantNoteItemAdapter(listOf(), viewModel)

        recyclerViewNoteImp.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewNoteImp.adapter = adapter

        viewModel.getAllImportantNoteItems().observe(viewLifecycleOwner, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })
    }

}
