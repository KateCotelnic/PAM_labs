package com.example.myapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.IngredientBinding

class MyAdapter4(val arrayList: ArrayList<String>):
        RecyclerView.Adapter<MyAdapter4.ViewHolder>() {

    inner class ViewHolder(val binding: IngredientBinding): RecyclerView.ViewHolder(binding.root){
        fun bindItems(ingredient: String){
            binding.nameIngredient.setText(ingredient)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(IngredientBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }
}