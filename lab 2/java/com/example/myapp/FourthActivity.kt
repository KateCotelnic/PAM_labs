package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name = intent.getStringExtra("name")
        binding.name.setText(name)
        val type = intent.getStringExtra("type")
        binding.type.setText(type)
        val image = intent.getIntExtra("image",0)
        binding.image.setImageResource(image)
        val ingredients = getIntent().getSerializableExtra("ingredients")
        val myAdapter = MyAdapter4(ingredients as ArrayList<String>, this)
        binding.ingredients.layoutManager = LinearLayoutManager(this)
        binding.ingredients.adapter = myAdapter
        val description = intent.getStringArrayListExtra("description")
        val adapter = MyAdapter4Recipe(description as ArrayList<String>, this)
        binding.recipe.layoutManager = LinearLayoutManager(this)
        binding.recipe.adapter = adapter
    }
    fun back(view: View){
        val newIntent = Intent(this, MainActivity::class.java)
        startActivity(newIntent)
    }
}