package com.humanoo.data.repository

import com.humanoo.data.common.Connectivity
import com.humanoo.data.mapper.toDomain
import com.humanoo.domain.model.RecipeDomainModel
import com.humanoo.domain.model.Result
import com.humanoo.domain.repository.RecipeRepository
import java.lang.Exception

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020
 * File Name : RecipeRepositoryImpl.kt
 * ClassName : RecipeRepositoryImpl
 * Module Name : app
 * Desc : RecipeRepositoryImpl Handle the Repository data.
 * Response parsing from remote source
 */

class RecipeRepositoryImpl constructor(
    private val recipeService: RecipeService,
    private val connectivity: Connectivity
) : RecipeRepository {

    override suspend fun getRecipesList(): Result<List<RecipeDomainModel>> {
        return if (connectivity.isNetworkAvailable()) {
            getRecipesData()
        } else return Result.Error("No Internet Connection")
    }

    private suspend fun getRecipesData(): Result<List<RecipeDomainModel>> {
        try {
            val response = recipeService.getRecipeList()
            if (response.isSuccessful) {
                val result = response.body().let {
                    it?.results!!.map {
                        it.toDomain()
                    }
                }
                result.let { return Result.Success(it) }
            }
            return Result.Error(("Error occurred during fetching recipes list!"))
        } catch (e: Exception) {
            return Result.Error(e.message.toString())
        }
    }


    override suspend fun getSearchRecipesList(searchQuery: String): Result<List<RecipeDomainModel>> {
        return if (connectivity.isNetworkAvailable()) {
            getDataFromNetwork(searchQuery)
        } else return Result.Error("No Internet Connection")
    }

    private suspend fun getDataFromNetwork(searchQuery: String): Result<List<RecipeDomainModel>> {
        try {
            val response = recipeService.searchRecipesByIngredient(searchQuery)
            if (response.isSuccessful) {
                val result = response.body().let {
                    it?.results!!.map {
                        it.toDomain()
                    }
                }
                result.let { return Result.Success(it) }
            }
            return Result.Error(("Error occurred during fetching recipes list!"))
        } catch (e: Exception) {
            return Result.Error(e.message.toString())
        }
    }
}