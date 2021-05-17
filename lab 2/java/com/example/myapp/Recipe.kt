package com.example.myapp

import kotlin.properties.Delegates

class Recipe{
    var name: String = "name"
    var type: String = "type"
    var image = 0
    var ingredients = ArrayList<String>()
    var description = ArrayList<String>()

    constructor(name: String, type: String, image: Int, ingredients: ArrayList<String>, description: ArrayList<String>) {
        this.name = name
        this.type = type
        this.image = image
        this.ingredients = ingredients
        this.description = description
    }
}