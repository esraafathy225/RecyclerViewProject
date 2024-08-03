package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.R

class UserAdapter(val data: List<User>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val tvName = row.findViewById<TextView>(R.id.tv_name)
        val tvEmail= row.findViewById<TextView>(R.id.tv_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_user,
            parent, false)
        return MyViewHolder(layout)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = data.get(position).name
        holder.tvEmail.text = data.get(position).email
    }
}