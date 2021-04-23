package com.example.myapp.data.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapp.data.api.ApiService
import com.example.myapp.data.model.RecipeModel
import com.example.myapp.data.util.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getMyRecipes()= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data=mainRepository.getMyRecipes()))
        }catch (exception: Exception){
            emit(Resource.error(data=null,message = exception.message?:"Error occured"))
        }
    }

    fun addRecipe(recipe: RecipeModel)= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data=mainRepository.addRecipe(recipe)))
        }catch (exception: Exception){
            emit(Resource.error(data=null,message = exception.message?:"Error occured"))
        }
    }

    fun getRecipes()= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data=mainRepository.getRecipes()))
        }catch (exception: Exception){
            emit(Resource.error(data=null,message = exception.message?:"Error occured"))
        }
    }

    fun deleteRecipe(recipe: RecipeModel)= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data=mainRepository.deleteRecipe(recipe)))
        }catch (exception: Exception){
            emit(Resource.error(data=null,message = exception.message?:"Error occured"))
        }
    }
}