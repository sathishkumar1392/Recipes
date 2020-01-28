package com.humanoo.domain.usecases

import com.humanoo.domain.model.RecipeDomainModel
import com.humanoo.domain.model.Result


/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020
 * File Name : RecipeUseCases.kt
 * ClassName : RecipeUseCases
 * Module Name : app
 * Desc : RecipeUseCases
 */
interface RecipeUseCases {

    suspend fun getRecipesList(): Result<List<RecipeDomainModel>>
    suspend fun getSearchRecipesList(searchQuery: String): Result<List<RecipeDomainModel>>
}