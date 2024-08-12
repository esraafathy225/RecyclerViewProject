package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerviewproject.R
import com.example.recyclerviewproject.databinding.ItemHeaderBinding
import com.example.recyclerviewproject.databinding.ItemUserBinding

class UserAdapter(val data: List<User>) : ListAdapter<User, ViewHolder>(UserItemDiffCallback()) {

    class MyViewHolder(val itemUserBinding: ItemUserBinding) :
        ViewHolder(itemUserBinding.root) {
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    class HeaderViewHolder(val itemHeaderBinding: ItemHeaderBinding) :
        ViewHolder(itemHeaderBinding.root) {
        companion object {
            fun from(parent: ViewGroup): HeaderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemHeaderBinding.inflate(layoutInflater, parent, false)
                return HeaderViewHolder(binding)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == 1)
            return HeaderViewHolder.from(parent)
        else return MyViewHolder.from(parent)
    }

    override fun getItemViewType(position: Int): Int {
        return data.get(position).type
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is MyViewHolder)
            holder.itemUserBinding.user = data.get(position)
        else if (holder is HeaderViewHolder)
            holder.itemHeaderBinding.user = data.get(position)
    }
}

class UserItemDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}
