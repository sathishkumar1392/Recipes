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

    private fun getRecipesData(): Result<List<RecipeDomainModel>> {
        return Result.Success(
            listOf(
                RecipeDomainModel(
                    "1",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe1"
                ),
                RecipeDomainModel(
                    "2",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe2"
                ),
                RecipeDomainModel(
                    "3",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe3"
                ),
                RecipeDomainModel(
                    "4",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe4"
                ),
                RecipeDomainModel(
                    "5",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe5"
                ),
                RecipeDomainModel(
                    "6",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe6"
                ),
                RecipeDomainModel(
                    "7",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe7"
                ),
                RecipeDomainModel(
                    "8",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe8"
                ),
                RecipeDomainModel(
                    "9",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe9"
                ),
                RecipeDomainModel(
                    "10",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe10"
                ),
                RecipeDomainModel(
                    "11",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe11"
                ),
                RecipeDomainModel(
                    "12",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe12"
                ),
                RecipeDomainModel(
                    "13",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe13"
                ),
                RecipeDomainModel(
                    "14",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe14"
                ),
                RecipeDomainModel(
                    "15",
                    "",
                    "sdasdfasdf asgf asdf asdf asdf asd",
                    "https://images-na.ssl-images-amazon.com/images/I/61IRhkRWTEL._SX466_.jpg",
                    "Recipe15"
                )
            )
        )
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