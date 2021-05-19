package com.example.myapp.ui.my_recipes

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.myapp.data.model.FakeDatabase
import com.example.myapp.databinding.ActivityFourthBinding
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.databinding.ActivitySecondBinding
import com.example.myapp.ui.all_recipes.SecondActivity
import org.junit.Test

@RunWith(JUnit4::class)
class SecondActivityTest{

    private lateinit var binding: ActivitySecondBinding
    private lateinit var binding1: ActivityFourthBinding
    @get: Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    val listItemInTest = 4
    val db = FakeDatabase("data")
    val recipeInTest = db.get(listItemInTest)

    //recycler
    @Test
    fun test_recycler_visible() {
        onView(withId(binding.recyclerView.id)).check(matches(isDisplayed()))
    }
    //select item
    @Test
    fun test_select_isVisible(){
        onView(withId(binding.recyclerView.id)).perform(RecyclerViewActions.actionOnItemAtPosition<MyAdapterMy.ViewHolder>(listItemInTest, click()))
        onView(withId(binding1.name.id)).check(matches(withText(recipeInTest.name)))
        onView(withId(binding1.type.id)).check(matches(withText(recipeInTest.type)))
        onView(withId(binding1.port.id)).check(matches(withText(recipeInTest.portions)))
    }
}