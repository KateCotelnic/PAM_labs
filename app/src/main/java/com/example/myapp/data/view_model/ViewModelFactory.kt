package com.example.myapp.data.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.data.api.ApiService

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(apiService) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}