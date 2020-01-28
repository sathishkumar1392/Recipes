package com.humanoo.domain.usecases

import com.humanoo.domain.model.RecipeDomainModel
import com.humanoo.domain.model.Result
import com.humanoo.domain.repository.RecipeRepository

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020
 * File Name : RecipeUseCasesImpl.kt
 * ClassName : RecipeUseCasesImpl
 * Module Name : app
 * Desc : Recipe data use case Implementation
 */

class RecipeUseCasesImpl(private val repo: RecipeRepository) : RecipeUseCases {
    override suspend fun getRecipesList(): Result<List<RecipeDomainModel>> {
        return repo.getRecipesList()
    }

    override suspend fun getSearchRecipesList(searchQuery: String): Result<List<RecipeDomainModel>> {
        return repo.getSearchRecipesList(searchQuery)
    }
}