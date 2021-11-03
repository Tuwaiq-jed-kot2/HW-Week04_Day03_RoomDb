package com.shady.room

import android.view.View
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter{






    class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val wordItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?){
            wordItemView.text = text
        }

    }


}