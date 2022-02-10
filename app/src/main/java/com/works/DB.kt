package com.works

import android.content.Context
import android.util.Log
import com.works.models.NoteModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.where
import java.util.*
import kotlin.collections.ArrayList

class DB ( val context: Context) {


    fun config() : Realm?{
        Realm.init(context)
        val conf = RealmConfiguration.Builder()
            .name("projectNote.db")
            .schemaVersion(1)
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .build()
        return Realm.getInstance(conf)
    }

    fun noteInsert(note: String) {
        val noteItem = NoteModel()
        noteItem.noteID = UUID.randomUUID().toString()
        noteItem.noteText = note
        config()?.executeTransaction {
            it.insert(noteItem)
        }
    }

    fun updateNote(noteID: String, noteText: String) {
        val noteItem = NoteModel()
        config()?.executeTransaction {
            noteItem.noteID = noteID
            noteItem.noteText = noteText

            it.insertOrUpdate(noteItem)
        }
    }

    fun deleteNote( noteID : String) {
        config()?.executeTransaction {
            it.where<NoteModel>().equalTo("noteID", noteID).findFirst()?.deleteFromRealm()
        }
    }

    fun getNotes() : ArrayList<NoteModel> {
        val arr = ArrayList<NoteModel>()
        config()?.executeTransaction {
            it.where<NoteModel>().findAll().forEach {
                arr.add(it)
            }
        }
        return arr
    }
}
