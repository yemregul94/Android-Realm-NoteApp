package com.works

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.works.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var bind : ActivityMainBinding
    lateinit var db: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        db = DB(this)


        bind.btnAddNote.setOnClickListener {

            val noteText = bind.txtNote.text
            if (TextUtils.isEmpty(noteText)){
                bind.txtNote.error = "Boş Bırakılamaz"
                bind.txtNote.requestFocus()
                return@setOnClickListener
            }
            db.noteInsert(noteText.toString())
            bind.txtNote.setText("")
            bind.txtNote.requestFocus()
            Toast.makeText(this, "Not Eklendi: $noteText", Toast.LENGTH_SHORT).show()
        }

        bind.btnList.setOnClickListener {
            val i = Intent(this, NoteList::class.java)
            startActivity(i)
            //finish()
        }
    }

}

