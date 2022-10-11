package com.example.apilocalhostapp

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter():RecyclerView.Adapter<DataAdapter.View>() {
    private  var list:ArrayList<ApiData> =ArrayList()
    private var onClickDeleteItem:((ApiData)->Unit)?=null
    private var onClickItem:((ApiData)->Unit)?=null
    class View(view:android.view.View):RecyclerView.ViewHolder(view){
        val name=view.findViewById(R.id.tv_name) as TextView
        val btnDelete=view.findViewById(R.id.btn_delete) as ImageView
    }
    fun addItems(item: ArrayList<ApiData>){
        this.list=item
        notifyDataSetChanged()
    }
    fun setOnClickItem(callback:(ApiData)->Unit){
        this.onClickItem=callback
    }
    fun setOnClickDeleteItem(callback:(ApiData)->Unit){
        this.onClickDeleteItem=callback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View {
        return View(LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false))
    }


    override fun onBindViewHolder(holder: View, position: Int) {
        val data=list[position]
        holder.name.text=data.name
        holder.itemView.setOnClickListener { onClickItem?.invoke(data) }
        holder.btnDelete.setOnClickListener { onClickDeleteItem?.invoke(data) }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}