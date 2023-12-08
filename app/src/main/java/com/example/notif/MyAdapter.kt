package com.example.notif

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val notiList: List<Notification>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView){
        val recycleTitle: TextView = itemView.findViewById(R.id.recycleTitle)
        val recycleDesc: TextView = itemView.findViewById(R.id.recycleDesc)
        val recycleDate: TextView = itemView.findViewById(R.id.recycleDate)
        val recycleTime: TextView = itemView.findViewById(R.id.recycleTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notiList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = notiList[position]
        holder.recycleTitle.text = currentItem.notiTitle
        holder.recycleDesc.text = currentItem.notiDesc
        holder.recycleDate.text = currentItem.notiDate
        holder.recycleTime.text = currentItem.notiTime
    }
}