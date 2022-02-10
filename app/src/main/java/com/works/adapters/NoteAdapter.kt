package com.works.adapters

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.works.DB
import com.works.NoteDetail
import com.works.databinding.ActivityNoteRowBinding
import com.works.models.NoteModel

class NoteAdapter (val arr: ArrayList<NoteModel>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    class ViewHolder(val bind: ActivityNoteRowBinding) : RecyclerView.ViewHolder(bind.root)

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind = ActivityNoteRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arr.get(position)
        val db = DB(holder.bind.root.context)

        holder.bind.apply {
            txtNote.text = item.noteText

            checkNote.setOnCheckedChangeListener { compoundButton, boold ->
                if(checkNote.isChecked)
                {
                    txtNote.setTextColor(Color.LTGRAY)
                    txtNote.setTypeface(null, Typeface.ITALIC)
                }
                else {
                    txtNote.setTextColor(Color.BLACK)
                    txtNote.setTypeface(null, Typeface.NORMAL)
                }
            }

            btnDelete.setOnClickListener {
                val alert = AlertDialog.Builder(holder.bind.root.context)
                alert.setTitle("Silme İşlemi!")
                alert.setMessage("Silmek istediğinizden emin misiniz? \nSilinecek Öge: ${txtNote.text}")
                alert.setNegativeButton("İptal", DialogInterface.OnClickListener { dialogInterface, i ->  })
                alert.setPositiveButton("Evet", DialogInterface.OnClickListener { dialogInterface, i ->

                    db.deleteNote(item.noteID!!)
                    arr.removeAt(position)
                    notifyDataSetChanged()
                    //notifyItemRemoved(position)
                })
                alert.show()

            }

            rowCardView.setOnClickListener {
                val i = Intent(holder.bind.root.context, NoteDetail::class.java)
                i.putExtra("noteID", item.noteID)
                i.putExtra("noteText", item.noteText)
                holder.bind.root.context.startActivity(i)
            }

            rowCardView.setOnLongClickListener {
                true
            }

        }

    }
}