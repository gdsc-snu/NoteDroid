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

package com.gdsc_snu.notedroid.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdsc_snu.notedroid.R
import com.gdsc_snu.notedroid.data.Note
import com.gdsc_snu.notedroid.ui.NoteViewModel
import kotlinx.android.synthetic.main.list_item.view.*

class NoteItemAdapter(
    var list: List<Note>,
    private val viewModel: NoteViewModel
) : RecyclerView.Adapter<NoteItemAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNoteItem = list[position]


        holder.itemView.titleTv.text = currentNoteItem.title
        holder.itemView.noteTv.text = currentNoteItem.text

        holder.itemView.deleteIcon.setOnClickListener {
            viewModel.delete(currentNoteItem)
        }

        holder.itemView.markImpBtn.setOnClickListener {
            currentNoteItem.isImp = true
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}