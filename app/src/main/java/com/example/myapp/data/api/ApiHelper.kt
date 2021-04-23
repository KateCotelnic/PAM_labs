package com.example.myapp.data.api

import com.example.myapp.data.model.RecipeModel
import retrofit2.http.FieldMap

class ApiHelper(private val apiService: ApiService) {

    suspend fun addRecipe(@FieldMap body: RecipeModel): RecipeModel = apiService.addRecipe(body)
    suspend fun getRecipes(): List<RecipeModel> = apiService.getRecipes()
    suspend fun getMyRecipes(): List<RecipeModel> = apiService.getMyRecipes()
    suspend fun deleteRecipe(@FieldMap body: RecipeModel): RecipeModel = apiService.deleteRecipe(body)
}