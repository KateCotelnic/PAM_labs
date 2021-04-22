package com.example.myapp.ui.my_recipes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.ui.recipe_details.FourthActivity
import com.example.myapp.data.view_model.MainViewModel
import com.example.myapp.data.model.RecipeModel
import com.example.myapp.databinding.RowMyBinding
import com.example.myapp.ui.delete_recipe.DeleteActivity

class MyAdapterMy(val arrayList: ArrayList<RecipeModel>, val context: Context):
    RecyclerView.Adapter<MyAdapterMy.ViewHolder>() {

    class ViewHolder(val binding: RowMyBinding): RecyclerView.ViewHolder(binding.root){

        fun convert(imagename: String): Int {
            if (imagename.equals("cream_soup"))
                return R.drawable.cream_soup
            else if (imagename.equals("burger"))
                return R.drawable.burger
            else if (imagename.equals("lasagna"))
                return R.drawable.lasagna
            else if (imagename.equals("pie"))
                return R.drawable.pie
            else if (imagename.equals("muffins"))
                return R.drawable.muffins
            else if (imagename.equals("colada"))
                return R.drawable.colada
            else
                return 0
        }

        fun bindItems(recipe: RecipeModel){
            binding.name.setText(recipe.name)
            binding.type.text = recipe.type
            binding.image.setImageResource(convert(recipe.image))
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
        val del: ImageButton = holder.itemView.findViewById(R.id.delete) as ImageButton
        del.setOnClickListener(){
            val intent = Intent( context, DeleteActivity::class.java)
            intent.putExtra("name", arrayList[position].name)
            intent.putExtra("type", arrayList[position].type)
            intent.putExtra("image", holder.convert(arrayList[position].image))
            intent.putExtra("ingredients", arrayList[position].ingredients)
            intent.putExtra("description", arrayList[position].description)
            context.startActivity(intent)
        }
        holder.itemView.setOnClickListener{
            val context=holder.itemView.context
            val intent = Intent( context, FourthActivity::class.java)
            intent.putExtra("name", arrayList[position].name)
            intent.putExtra("type", arrayList[position].type)
            intent.putExtra("image", holder.convert(arrayList[position].image))
            intent.putExtra("ingredients", arrayList[position].ingredients)
            intent.putExtra("description", arrayList[position].description)
            context.startActivity(intent)
        }
    }
}
