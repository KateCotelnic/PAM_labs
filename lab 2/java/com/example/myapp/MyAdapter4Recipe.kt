package com.example.myapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter4Recipe(val arrayList: ArrayList<String>, val context: Context):
        RecyclerView.Adapter<MyAdapter4Recipe.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var i = 0
        fun bindItems(description: String){
            val desc = itemView.findViewById(R.id.recipe_description_text) as? TextView
            println("current ingredient:" + description)
            if (desc != null) {
                i++
                desc.setText("$i) $description")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recipe_description,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }
}
