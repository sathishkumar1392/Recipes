package com.humanoo.recipes.viewmodelTest

import com.humanoo.data.BaseTest
import com.humanoo.domain.model.RecipeDomainModel
import com.humanoo.domain.model.Result
import com.humanoo.domain.usecases.RecipeUseCases
import com.humanoo.recipes.presentation.recipe.viewmodel.RecipeViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :14-01-2020 
 * File Name : RecipeViewModelTest.kt
 * ClassName : RecipeViewModelTest
 * Module Name : app
 * Desc : 
 */

class RecipeViewModelTest :BaseTest(){

    @Mock
    private lateinit var useCase: RecipeUseCases

    @Mock
    private lateinit var recipeListViewModel: RecipeViewModel

    private val recipeList = emptyList<RecipeDomainModel>()


    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        recipeListViewModel = RecipeViewModel(useCase)
    }


    @Test
    fun  loadRecipeList_Success () = runBlocking{
        val result = Result.Success(recipeList)
            `when`(useCase.getRecipesList()).thenReturn(result)
            val response = useCase.getRecipesList()
            Assert.assertEquals(result,response)
        }

    @Test
    fun loadRecipeSearchListTest_Success() = runBlocking {
        val searchQuery = "qwerty"
        val result = Result.Success(recipeList)
        `when`(useCase.getSearchRecipesList(searchQuery)).thenReturn(result)
        val response = useCase.getSearchRecipesList(searchQuery)
        Assert.assertEquals(result,response)
    }


    @Test
    fun loadRecipeSearchListTest_Failure() = runBlocking {
        val searchQuery = ""
            val result = Result.Error("Please add longer Query")
            `when`(useCase.getSearchRecipesList(searchQuery)).thenReturn(result)
            val response = Result.Error("Please add longer Query")
            Assert.assertEquals(result, response)
        }
}