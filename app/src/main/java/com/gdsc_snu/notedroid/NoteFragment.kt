package com.gdsc_snu.notedroid

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_note.*


class NoteFragment : Fragment(R.layout.fragment_note) {

    private fun openDialog() {
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.add_note)
        val cancelBtn = dialog.findViewById<Button>(R.id.idBtnCancel)
        val addBtn = dialog.findViewById<Button>(R.id.idBtnAdd)
        val noteTitle = dialog.findViewById<EditText>(R.id.TitleAddEt)
        val noteMain = dialog.findViewById<EditText>(R.id.NoteAddEt)
        cancelBtn.setOnClickListener {
            dialog.dismiss()
        }
        addBtn.setOnClickListener {
            Log.d("NoteFragment", "Item Added Successfully")
        }
        dialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFAB.setOnClickListener {
            openDialog()
        }
    }

}