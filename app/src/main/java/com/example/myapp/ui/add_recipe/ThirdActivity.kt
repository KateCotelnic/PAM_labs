package com.example.myapp.ui.add_recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapp.data.api.ApiClient
import com.example.myapp.data.api.ApiHelper
import com.example.myapp.data.api.ApiService
import com.example.myapp.data.model.RecipeModel
import com.example.myapp.data.view_model.MainViewModel
import com.example.myapp.data.view_model.ViewModelFactory
import com.example.myapp.databinding.ActivityThirdBinding
import com.example.myapp.ui.my_recipes.MainActivity
import com.example.myapp.data.util.Status

class ThirdActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupViewModel()

        var options = arrayOf("main cource", "first course", "second course", "dessert", "drinks")
        var type = "main course"


        binding.include2.spOption.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, options)

        binding.include2.spOption.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                type = options.get(position)
            }
        }

        binding.save.setOnClickListener {
            var name = binding.include.nameOfDish.text.toString()
            var ingredients = binding.include.insertIngredients.text.toString()
            var description = binding.include.preparationDescription.text.toString()
            if(!InputValidation.check_input(name)){
                binding.include.nameOfDish.setText("improper name")
            }
            if(!InputValidation.check_input(description)){
                binding.include.preparationDescription.setText("improper description")
                if(!InputValidation.check_input(ingredients)){
                    binding.include.nameOfDish.setText("improper ingredients")
                }
            }
            else {
                addNewRecipeApi(name, type, ingredients, description)
                val newIntent = Intent(this, MainActivity::class.java)
                startActivity(newIntent)
            }
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
                ViewModelFactory(ApiHelper(ApiClient.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun addNewRecipeApi(name: String, type: String, ingredients: String, description: String) {

        viewModel.addRecipe(createRecipe(name, type, ingredients, description)).observe(this, Observer {

            it?.let { resource ->
                when (resource.status) {

                    Status.SUCCESS -> {
                        resource.data?.let { recipe -> addNewRecipe() }
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

    private fun createRecipe(name: String, type: String, ingredients: String, description: String) : RecipeModel {
        var ingr = ingredients.split(", ")
        var desc = description.split(", ")
        return RecipeModel("kkate", name, type, "image", ingr as ArrayList<String>,
                desc as ArrayList<String>, 1
        )
    }

    private fun addNewRecipe(){
    }
}