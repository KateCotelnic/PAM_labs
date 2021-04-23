package com.example.myapp.data.view_model

import com.example.myapp.data.api.ApiHelper
import com.example.myapp.data.model.RecipeModel
import retrofit2.http.FieldMap

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun addRecipe(@FieldMap body: RecipeModel): RecipeModel = apiHelper.addRecipe(body)
    suspend fun getRecipes(): List<RecipeModel> = apiHelper.getRecipes()
    suspend fun getMyRecipes(): List<RecipeModel> = apiHelper.getMyRecipes()
    suspend fun deleteRecipe(@FieldMap body: RecipeModel): RecipeModel = apiHelper.deleteRecipe(body)
}