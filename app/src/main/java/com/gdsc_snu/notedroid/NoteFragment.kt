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
import com.gdsc_snu.notedroid.data.Note
import com.gdsc_snu.notedroid.db.NoteDatabase
import com.gdsc_snu.notedroid.db.NoteRepository
import com.gdsc_snu.notedroid.recycler_view.NoteItemAdapter
import com.gdsc_snu.notedroid.ui.AddDialogListener
import com.gdsc_snu.notedroid.ui.AddNoteItemDialog
import com.gdsc_snu.notedroid.ui.NoteViewModel
import com.gdsc_snu.notedroid.ui.NoteViewModelFactory
import kotlinx.android.synthetic.main.fragment_note.*


class NoteFragment : Fragment(R.layout.fragment_note) {

    private lateinit var factory: NoteViewModelFactory
    private lateinit var viewModel: NoteViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = NoteDatabase(requireContext())
        val repository = NoteRepository(db)
        factory = NoteViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)

        val adapter = NoteItemAdapter(listOf(), viewModel)

        recyclerViewNote.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewNote.adapter = adapter

        viewModel.getAllNoteItems().observe(viewLifecycleOwner, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })

        addFAB.setOnClickListener {
            AddNoteItemDialog(requireContext(),
                addDialogListener = object : AddDialogListener {
                    override fun onAddButtonClicked(item: Note) {
                        viewModel.insert(item)
                    }
                }).show()
        }

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//

}