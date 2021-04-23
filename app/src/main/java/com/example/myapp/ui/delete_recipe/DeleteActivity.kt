package com.example.myapp.ui.delete_recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.data.api.ApiClient
import com.example.myapp.data.api.ApiHelper
import com.example.myapp.data.api.ApiService
import com.example.myapp.data.model.RecipeModel
import com.example.myapp.data.util.Status
import com.example.myapp.data.view_model.MainViewModel
import com.example.myapp.data.view_model.ViewModelFactory
import com.example.myapp.databinding.ActivityDeleteBinding
import com.example.myapp.ui.my_recipes.MainActivity
import com.example.myapp.ui.recipe_details.MyAdapter4

class DeleteActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityDeleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupViewModel()
        val name = intent.getStringExtra("name").toString()
        val question = binding.ask.text.toString() + name + "?"
        binding.ask.setText(question)
        val type = intent.getStringExtra("type").toString()
        val image = intent.getIntExtra("image",0).toString()
        val ingredients = getIntent().getSerializableExtra("ingredients") as ArrayList<String>
        val description = intent.getStringArrayListExtra("description") as ArrayList<String>

        binding.yes.setOnClickListener {
            delete(RecipeModel("kkate", name, type, image, ingredients, description))
            val newIntent = Intent(this, MainActivity::class.java)
            startActivityForResult(newIntent, 0)
        }

        binding.no.setOnClickListener {

            val newIntent = Intent(this, MainActivity::class.java)
            startActivityForResult(newIntent, 0)
        }
    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(ApiHelper(ApiClient.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun delete(recipe: RecipeModel) {

        viewModel.deleteRecipe(recipe).observe(this, Observer {

            it?.let { resource ->
                when (resource.status) {

                    Status.SUCCESS -> {
                        Toast.makeText(this, "${recipe.name} deleted!", Toast.LENGTH_LONG).show()
                        val newIntent = Intent(this, MainActivity::class.java)
                        startActivity(newIntent)
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, "${recipe.name} deleted!", Toast.LENGTH_LONG).show()
//                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        val newIntent = Intent(this, MainActivity::class.java)
                        startActivity(newIntent)
                    }
                    Status.LOADING -> {
                    }
                }

            }
        })
    }
}