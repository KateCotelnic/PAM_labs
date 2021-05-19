package com.example.myapp.data.model

object RecipeCalculator {

    public fun getCal(ingredients: ArrayList<String>): Int{
       var n = 0
        for(integr in ingredients){
            var s = integr.split(' ').last().toInt()
                n = n + s
        }
        return n
    }

    public fun getCal(cal: Int, portions: Int, portionNr: Int): Int{
        var n = portionNr*cal/portions
        return n
    }
}