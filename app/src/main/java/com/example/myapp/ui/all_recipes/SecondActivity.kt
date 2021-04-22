package com.example.myapp.ui.all_recipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.R
import com.example.myapp.ui.add_recipe.ThirdActivity
import com.example.myapp.data.api.ApiClient
import com.example.myapp.data.api.ApiService
import com.example.myapp.data.model.RecipeModel
import com.example.myapp.data.view_model.MainViewModel
import com.example.myapp.data.view_model.ViewModelFactory
import com.example.myapp.databinding.ActivitySecondBinding
import com.example.myapp.ui.my_recipes.MainActivity
import com.example.myapp.data.util.Status
import com.google.android.material.navigation.NavigationView

class SecondActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    var recipeList = ArrayList<RecipeModel>()
    private lateinit var viewModel: MainViewModel
    private lateinit var myAdapter: MyAdapterAll
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root

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

        setContentView(view)
        setupViewModel()

        myAdapter = MyAdapterAll(recipeList, this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter

        binding.myRecipes.setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
        binding.add.setOnClickListener {
            val newIntent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(newIntent, 0)
        }
        setUpObserver()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
                ViewModelFactory(
                        ApiClient.apiClient().create(ApiService::class.java)
                )
        ).get(MainViewModel::class.java)
    }

    private fun setUpObserver() {

        viewModel.getRecipes().observe(this, Observer {

            it?.let { resource ->
                when (resource.status) {

                    Status.SUCCESS -> {
                        resource.data?.let { recipes -> retrieveList(recipes) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }

            }
        })
    }

    private fun retrieveList(recipes: List<RecipeModel>) {
        if (recipes.size > 0) {
            recipeList.addAll(recipes)
            myAdapter.notifyDataSetChanged()
        }
    }
}