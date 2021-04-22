package com.example.myapp.ui.my_recipes
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.R
import com.example.myapp.ui.all_recipes.SecondActivity
import com.example.myapp.ui.add_recipe.ThirdActivity
import com.example.myapp.data.api.ApiClient
import com.example.myapp.data.api.ApiService
import com.example.myapp.data.model.RecipeModel
import com.example.myapp.data.view_model.MainViewModel
import com.example.myapp.data.view_model.ViewModelFactory
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.data.util.Status
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    var recipeList = ArrayList<RecipeModel>()
    private lateinit var viewModel: MainViewModel
    private lateinit var myAdapter: MyAdapterMy
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

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
        setupViewModel()

        myAdapter = MyAdapterMy(recipeList, this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter

        binding.allRecipes.setOnClickListener {
            val newIntent = Intent(this, SecondActivity::class.java)
            startActivity(newIntent)
        }

        binding.add.setOnClickListener {
            val newIntent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(newIntent, 0)
        }

        setUpObserver()
    }

    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(navView)
        return true
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

        viewModel.getMyRecipes().observe(this, Observer {

            it?.let { resource ->
                when (resource.status) {

                    Status.SUCCESS -> {
                        resource.data?.let { recipes ->retrieveList(recipes) }
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