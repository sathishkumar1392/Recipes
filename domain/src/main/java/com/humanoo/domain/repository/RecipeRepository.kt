package com.humanoo.domain.repository

import com.humanoo.domain.model.RecipeDomainModel
import com.humanoo.domain.model.Result

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020
 * File Name : RecipeRepository.kt
 * ClassName : RecipeRepository
 * Module Name : app
 * Desc : RecipeRepository
 */
interface RecipeRepository {
    suspend fun getRecipesList(): Result<List<RecipeDomainModel>>
    suspend fun getSearchRecipesList(searchQuery: String): Result<List<RecipeDomainModel>>
}