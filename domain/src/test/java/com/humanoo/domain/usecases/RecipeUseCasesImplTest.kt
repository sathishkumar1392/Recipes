package com.humanoo.domain.usecases

import com.humanoo.domain.model.RecipeDomainModel
import com.humanoo.domain.model.Result
import com.humanoo.domain.repository.RecipeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :14-01-2020
 * File Name : RecipeUseCasesImplTest.kt
 * ClassName : RecipeUseCasesImplTest
 * Module Name : app
 * Desc :
 */
class RecipeUseCasesImplTest {

    @Mock
    lateinit var repo: RecipeRepository

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun getRecipesList_Success() {
        val useCases = RecipeUseCasesImpl(repo)
        val data = emptyList<RecipeDomainModel>()

        runBlocking {
            val result = Result.Success(data)
            `when`(repo.getRecipesList()).thenReturn(result)
            val resultInUseCase = useCases.getRecipesList()
            assertEquals(result, resultInUseCase)
        }
    }

    @Test
    fun getRecipesList_Failure() {
        runBlocking {
            val result = Result.Error("No Internet connection")
            `when`(repo.getRecipesList()).thenReturn(result)
            val resultInUseCase = Result.Error("No Internet connection")
            assertEquals(result, resultInUseCase)
        }
    }


    @Test
    fun getSearchRecipesList_Success() {
        val searchQuery = "test"
        val useCases = RecipeUseCasesImpl(repo)
        val data = emptyList<RecipeDomainModel>()

        runBlocking {
            val result = Result.Success(data)
            `when`(repo.getSearchRecipesList(searchQuery)).thenReturn(result)
            val resultInUseCase = useCases.getSearchRecipesList(searchQuery)
            assertEquals(result, resultInUseCase)
        }
    }


    @Test
    fun getSearchRecipesList_Failure() {
        val searchQuery = ""
        runBlocking {
            val result = Result.Error("No data found")
            `when`(repo.getSearchRecipesList(searchQuery)).thenReturn(result)
            val resultInUseCase = Result.Error("No data found")
            assertEquals(result, resultInUseCase)
        }
    }
}

