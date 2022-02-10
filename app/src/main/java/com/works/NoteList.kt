package com.works

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.works.adapters.NoteAdapter
import com.works.databinding.ActivityNoteListBinding

class NoteList : AppCompatActivity() {

    lateinit var db: DB
    lateinit var bind : ActivityNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        bind = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(bind.root)

        updateView()
    }

    override fun onRestart() {
        super.onRestart()
        updateView()
    }

    fun updateView() {
        db = DB(this)
        bind.noteList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val notes = db.getNotes()
        bind.noteList.adapter = NoteAdapter(notes)
    }
}