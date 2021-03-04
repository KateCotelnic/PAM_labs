package com.example.myapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapterAll(val arrayList: ArrayList<Recipe>, val context: Context):
        RecyclerView.Adapter<MyAdapterAll.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val title: TextView = itemView.findViewById(R.id.name) as TextView
        val description: TextView = itemView.findViewById(R.id.type) as TextView
        val image: ImageView = itemView.findViewById(R.id.image) as ImageView

        fun bindItems(recipe: Recipe){
            title.setText(recipe.name)
            description.text = recipe.type
            image.setImageResource(recipe.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_all,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener{
//            if(position == 0){
            val context=holder.itemView.context
            val intent = Intent( context, FourthActivity::class.java)
            intent.putExtra("name", arrayList[position].name)
            intent.putExtra("type", arrayList[position].type)
            intent.putExtra("image", arrayList[position].image)
            intent.putExtra("ingredients", arrayList[position].ingredients)
            intent.putExtra("description", arrayList[position].description)
            context.startActivity(intent)
//            }
        }
        val add: Button = holder.itemView.findViewById(R.id.add) as Button
        add.setOnClickListener(){
            val myToast = Toast.makeText(context, arrayList[position].name + " added!", Toast.LENGTH_SHORT)
            myToast.show()
        }
    }
}