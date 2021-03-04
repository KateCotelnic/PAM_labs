package com.example.myapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter4(val arrayList: ArrayList<String>, val context: Context):
        RecyclerView.Adapter<MyAdapter4.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindItems(ingredient: String){
            val title: TextView = itemView.findViewById(R.id.name_ingredient) as TextView
            title.setText(ingredient)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.ingredient,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

    }
}