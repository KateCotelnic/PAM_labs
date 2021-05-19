package com.example.myapp.ui.add_recipe

import java.util.regex.Matcher
import java.util.regex.Pattern

object InputValidation {
    fun check_input(str: String) : Boolean{
        var s = str.replace("(","")
        s = s.replace(")","")
        s = s.replace(" ","")
        s = s.replace(",","")
        s = s.replace(".","")
        val p: Pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE)
        if(str == null)
            return false
        val m: Matcher = p.matcher(s)
        val b: Boolean = m.find()
        if (b)
            return false
        return true
    }
}