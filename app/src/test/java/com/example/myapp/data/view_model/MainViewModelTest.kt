package com.example.myapp.data.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.myapp.data.model.RecipeModel
import com.example.myapp.data.util.Resource
import com.example.myapp.data.utils.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest{
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var recipeModelObserver: Observer<Resource<List<RecipeModel>>>

    @Before
    fun setUp() {
        // do something if required
    }
    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(emptyList<RecipeModel>())
                .`when`(mainRepository)
                .getRecipes()
            val viewModel = MainViewModel(mainRepository)
            viewModel.getRecipes().observeForever(recipeModelObserver)
            verify(mainRepository).getRecipes()
            verify(recipeModelObserver).onChanged(Resource.success(emptyList()))
            viewModel.getRecipes().removeObserver(recipeModelObserver)
        }
    }

    @Test
    fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            doThrow(RuntimeException(errorMessage))
                .`when`(mainRepository)
                .getRecipes()
            val viewModel = MainViewModel(mainRepository)
            viewModel.getRecipes().observeForever(recipeModelObserver)
            verify(mainRepository).getRecipes()
            verify(recipeModelObserver).onChanged(
                Resource.error(null,
                    RuntimeException(errorMessage).toString()
                )
            )
            viewModel.getRecipes().removeObserver(recipeModelObserver)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }

}