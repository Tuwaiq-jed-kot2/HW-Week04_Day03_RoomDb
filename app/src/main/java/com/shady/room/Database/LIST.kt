package com.shady.room.Database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shady.room.Home
import com.shady.room.R

class HomeListAdapter : ListAdapter<Home,HomeListAdapter>(HomesComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.create(parent)

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.home)
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val homeItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            homeItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): HomeViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_main, parent, false)
                return HomeViewHolder(view)
            }
        }
    }

    class HomesComparator : DiffUtil.ItemCallback<Home>() {
        override fun areItemsTheSame(oldItem: Home, newItem: Home): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Home, newItem: Home): Boolean {
            return oldItem.home == newItem.home
        }
    }
}