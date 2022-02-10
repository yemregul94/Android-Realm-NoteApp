package com.works

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.works.databinding.ActivityNoteDetailBinding

class NoteDetail : AppCompatActivity() {

    lateinit var bind : ActivityNoteDetailBinding
    lateinit var db : DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        bind = ActivityNoteDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        db = DB(this)
        val noteID = intent.getStringExtra("noteID")
        val noteText = intent.getStringExtra("noteText")
        val oldText = noteText

        bind.txtDetail.setText(noteText)


        bind.btnUpdate.setOnClickListener {
            val noteText = bind.txtDetail.text.toString()
            if (TextUtils.isEmpty(noteText)){
                bind.txtDetail.error = "Boş Bırakılamaz"
                bind.txtDetail.requestFocus()
                return@setOnClickListener
            }

            val alert = AlertDialog.Builder(bind.root.context)
            alert.setTitle("Güncelleme İşlemi!")
            alert.setMessage("Güncellemek istediğinizden emin misiniz? \nEski Değer: ${oldText}\nYeni Değer: ${noteText}")
            alert.setNegativeButton("İptal", DialogInterface.OnClickListener { dialogInterface, i ->  })
            alert.setPositiveButton("Evet", DialogInterface.OnClickListener { dialogInterface, i ->

                db.updateNote(noteID!!, noteText)
                Toast.makeText(this@NoteDetail, "Not Güncellendi", Toast.LENGTH_SHORT).show()
            })
            alert.show()
            }
        }
    }
