package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        val name = intent.getStringExtra("name")
        val nameA: TextView = findViewById(R.id.name) as TextView
    println("name = " + name)
        nameA.setText(name)
        val type = intent.getStringExtra("type")
        val typeA: TextView = findViewById(R.id.type) as TextView
    println("type = " + type)
        typeA.setText(type)
        val image = intent.getIntExtra("image",0)
        val imageA: ImageView = findViewById(R.id.image) as ImageView
    println("image = " + image)
        imageA.setImageResource(image)
        val ingredients = getIntent().getSerializableExtra("ingredients")
    println("ingred = " + ingredients)
        val myAdapter = MyAdapter4(ingredients as ArrayList<String>, this)
        val  recyclerView: RecyclerView = findViewById(R.id.ingredients) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter
        val description = intent.getStringArrayListExtra("description")
    println("desc = " + description)
        val adapter = MyAdapter4Recipe(description as ArrayList<String>, this)
        val  recycler: RecyclerView = findViewById(R.id.recipe) as RecyclerView
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }
    fun back(view: View){
        val newIntent = Intent(this, MainActivity::class.java)
        startActivity(newIntent)
    }
}
