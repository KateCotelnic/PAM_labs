package com.example.myapp.ui.recipe_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.R
import com.example.myapp.data.model.RecipeCalculator
import com.example.myapp.databinding.ActivityFourthBinding
import com.example.myapp.ui.add_recipe.ThirdActivity
import com.example.myapp.ui.all_recipes.SecondActivity
import com.example.myapp.ui.my_recipes.MainActivity
import com.google.android.material.navigation.NavigationView

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)

        drawerLayout = binding.drawerLayout
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.my -> {
                    val newIntent = Intent(this, MainActivity::class.java)
                    startActivity(newIntent)
                    true
                }
                R.id.all -> {
                    val newIntent = Intent(this, SecondActivity::class.java)
                    startActivity(newIntent)
                    true
                }
                R.id.add -> {
                    val newIntent = Intent(this, ThirdActivity::class.java)
                    startActivity(newIntent)
                    true
                }
                else -> {
                    false
                }
            }
        }

        val view = binding.root
        setContentView(view)

        val name = intent.getStringExtra("name")
        binding.name.setText(name)
        val type = intent.getStringExtra("type")
        binding.type.setText(type)
        val image = intent.getIntExtra("image",0)
        binding.image.setImageResource(image)
        val ingredients = getIntent().getSerializableExtra("ingredients")
        val myAdapter = MyAdapter4(ingredients as ArrayList<String>)
        binding.ingredients.layoutManager = LinearLayoutManager(this)
        binding.ingredients.adapter = myAdapter
        val description = intent.getStringArrayListExtra("description")
        val adapter = MyAdapter4Recipe(description as ArrayList<String>)
        var portions = intent.getIntExtra("portions", 1)
        binding.port.setText(portions.toString() + " portions")
        val cal = RecipeCalculator.getCal(ingredients)
        binding.cal.setText(cal.toString() + " cal")
        binding.recipe.layoutManager = LinearLayoutManager(this)
        binding.recipe.adapter = adapter

        binding.imageButton.setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
        binding.up.setOnClickListener {
            val pr = binding.port.text.toString().toInt()
            binding.cal.setText(RecipeCalculator.getCal(cal, portions, pr))
        }
        binding.down.setOnClickListener {
            val pr = binding.port.text.toString().toInt()
            binding.cal.setText(RecipeCalculator.getCal(cal, portions, pr))
        }
    }
}