package com.example.myapp.ui.add_recipe

import com.example.myapp.data.model.RecipeCalculator
import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class InputValidationTest {

    @Test
    fun check_input_null() {
        val input = ""
        val result = InputValidation.check_input(input)
        Truth.assertThat(result).isEqualTo(false)
    }

    @Test
    fun check_input_false() {
        val input = "trbtnr*"
        val result = InputValidation.check_input(input)
        Truth.assertThat(result).isEqualTo(false)
    }

    @Test
    fun check_input_true() {
        val input = "trbtnr rtrrt trhtrr . ( rtyu,)"
        val result = InputValidation.check_input(input)
        Truth.assertThat(result).isEqualTo(true)
    }
}