package com.example.myapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.IngredientBinding
import com.example.myapp.databinding.RecipeDescriptionBinding

class MyAdapter4Recipe(val arrayList: ArrayList<String>):
        RecyclerView.Adapter<MyAdapter4Recipe.ViewHolder>() {

    inner class ViewHolder(val binding: RecipeDescriptionBinding): RecyclerView.ViewHolder(binding.root){
        var i = 0
        fun bindItems(description: String){
            val desc = binding.recipeDescriptionText
            if (desc != null) {
                i++
                desc.setText("$i) $description")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecipeDescriptionBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }
}
