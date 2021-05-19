package com.example.myapp.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RecipeCalculatorTest {

    @Test
    fun getCal() {
        val ingr = arrayListOf("4 tablespoons butter, 200","1 tablespoon oil, 150","2 onions diced, 5","4 cloves garlic minced, 0","1 1/2 pounds (750 g) fresh brown mushrooms sliced, 110","4 teaspoons chopped thyme divided, 0","1/2 cup Marsala wine (any dry red or white wine), 67","6 tablespoons all-purpose flour, 230","4 cups low sodium chicken broth or stock, 120","1-2 teaspoons salt adjust to taste, 0","1/2-1 teaspoons black cracked pepper adjust to taste, 0","2 beef bouillon cubes, crumbled, 15","1 cup heavy cream or half and half (sub with evaporated milk), 150","Chopped fresh parsley and thyme to serve, 0")
        val result = RecipeCalculator.getCal(ingr)
        assertThat(result).isEqualTo(1047)
    }

    @Test
    fun testGetCal() {
        val old_cal = 1047
        val old_portions = 3
        val new_portions = 9
        val new_cal = RecipeCalculator.getCal(old_cal, old_portions, new_portions)
        assertThat(new_cal).isEqualTo(3141)
    }
}