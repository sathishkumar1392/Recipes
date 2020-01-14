package com.humanoo.data

import com.humanoo.data.common.Connectivity
import com.humanoo.data.model.RecipesApiResponseModel
import com.humanoo.data.repository.RecipeRepositoryImpl
import com.humanoo.data.repository.RecipeService
import com.humanoo.domain.model.RecipeDomainModel
import com.humanoo.domain.model.Result
import com.humanoo.domain.usecases.RecipeUseCasesImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :14-01-2020 
 * File Name : RecipeRepositoryImplTest.kt
 * ClassName : RecipeRepositoryImplTest
 * Module Name : app
 * Desc : 
 */

class RecipeRepositoryImplTest:BaseTest() {

    @Mock
    private lateinit var recipeService: RecipeService

    @Mock
    private lateinit var connectivity: Connectivity

    @InjectMocks
    private lateinit var repo: RecipeRepositoryImpl

    @Before
    fun init(){
        MockitoAnnotations.initMocks(this)
        repo = RecipeRepositoryImpl(recipeService,connectivity)
    }

    @Test
    fun testRecipeList_Success() {
        val result = Response.success<RecipesApiResponseModel>(RecipesApiResponseModel())
        result.code()

        runBlocking {
            `when`(connectivity.isNetworkAvailable()).thenReturn(true)
            `when`(recipeService.getRecipeList()).thenReturn(result)
            val response  = recipeService.getRecipeList()
            Assert.assertEquals(result,response)
        }
    }

    @Test
    fun testRecipeList_Failure() {
        val result = Result.Error("No Internet connection")
        runBlocking {
            `when`(connectivity.isNetworkAvailable()).thenReturn(false)
            val response = Result.Error("No Internet connection")
            Assert.assertEquals(result,response)
        }
    }


    @Test
    fun testSearchRecipeList_Success() {
        val searchQuery = "test1"
        val result = Response.success<RecipesApiResponseModel>(RecipesApiResponseModel())
        result.code()

        runBlocking {
            `when`(connectivity.isNetworkAvailable()).thenReturn(true)
            `when`(recipeService.searchRecipesByIngredient(searchQuery)).thenReturn(result)
            val response  = recipeService.searchRecipesByIngredient(searchQuery)
            Assert.assertEquals(result,response)
        }
    }

    @Test
    fun testSearchRecipeList_Failure() {
        val searchQuery = ""
        val result = Response.success<RecipesApiResponseModel>(RecipesApiResponseModel())

        runBlocking {
            `when`(connectivity.isNetworkAvailable()).thenReturn(true)
            `when`(recipeService.searchRecipesByIngredient(searchQuery)).thenReturn(result)
            val response  = recipeService.searchRecipesByIngredient(searchQuery)
            Assert.assertEquals(result,response)
        }
    }

}