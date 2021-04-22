package com.example.myapp.ui.recipe_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.RecipeDescriptionBinding

class MyAdapter4Recipe(val arrayList: ArrayList<String>):
        RecyclerView.Adapter<MyAdapter4Recipe.ViewHolder>() {

    inner class ViewHolder(val binding: RecipeDescriptionBinding): RecyclerView.ViewHolder(binding.root){
        fun bindItems(description: String){
            val desc = binding.recipeDescriptionText
                desc.setText("-> $description")
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
