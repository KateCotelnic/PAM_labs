package com.example.myapp.data.api

import com.example.myapp.data.model.RecipeModel
import com.google.gson.JsonObject
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("recipes")
    suspend fun addRecipe(@FieldMap body: RecipeModel): RecipeModel

    @GET("recipes")
    suspend fun getRecipes(): List<RecipeModel>

    @GET("recipes?username=kkate")
    suspend fun getMyRecipes(): List<RecipeModel>

    @FormUrlEncoded
    @POST("recipes/delet")
    suspend fun deleteRecipe(@FieldMap body: RecipeModel): RecipeModel
}