package com.example.apilocalhostapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private var list:ArrayList<ApiData>):RecyclerView.Adapter<DataAdapter.View>() {
    class View(view:android.view.View):RecyclerView.ViewHolder(view){
        val name=view.findViewById(R.id.tv_name) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View {
        return View(LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false))
    }

    override fun onBindViewHolder(holder: View, position: Int) {
        val data=list[position]
        holder.name.text=data.name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}