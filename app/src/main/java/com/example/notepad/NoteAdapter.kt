package com.example.notepad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter (
    val notes: List<Note>,
    val itemClickListener: View.OnClickListener
    ): RecyclerView.Adapter<NoteAdapter.ViewHolder>()
{
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_view)
        val titleView = cardView.findViewById<TextView>(R.id.title)
        val exerptView = cardView.findViewById<TextView>(R.id.exerpt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_note_list, parent, false
            )
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        val note = notes[position]
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = position
        holder.titleView = note.title
        holder.exerptView = note.exerpt
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}