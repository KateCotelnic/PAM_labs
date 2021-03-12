package com.example.myapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.RowAllBinding
import com.example.myapp.databinding.RowMyBinding

class MyAdapterMy(val arrayList: ArrayList<Recipe>, val context: Context):
    RecyclerView.Adapter<MyAdapterMy.ViewHolder>() {

    class ViewHolder(val binding: RowMyBinding): RecyclerView.ViewHolder(binding.root){

        fun bindItems(recipe: Recipe){
            binding.name.setText(recipe.name)
            binding.type.text = recipe.type
            binding.image.setImageResource(recipe.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowMyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener{
            val context=holder.itemView.context
            val intent = Intent( context, FourthActivity::class.java)
            intent.putExtra("name", arrayList[position].name)
            intent.putExtra("type", arrayList[position].type)
            intent.putExtra("image", arrayList[position].image)
            intent.putExtra("ingredients", arrayList[position].ingredients)
            intent.putExtra("description", arrayList[position].description)
            context.startActivity(intent)
        }
    }
}