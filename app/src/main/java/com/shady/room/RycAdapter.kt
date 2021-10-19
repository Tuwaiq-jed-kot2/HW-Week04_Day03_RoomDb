package com.shady.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RycAdapter(private val cList: List<Word>) : RecyclerView.Adapter<RycAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = cList[position]


        holder.itemTextView.setText(ItemsViewModel.word)

    }

    override fun getItemCount(): Int {
        return cList.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val itemTextView: TextView = itemView.findViewById(R.id.itemTv)


    }
}
