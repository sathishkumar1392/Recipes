package com.humanoo.recipes.presentation.recipe.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.humanoo.domain.model.RecipeDomainModel
import com.humanoo.domain.model.Result
import com.humanoo.domain.usecases.RecipeUseCases
import com.humanoo.recipes.model.RecipeData
import com.humanoo.recipes.model.toPresenter
import com.humanoo.recipes.presentation.recipe.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 12-01-2020
 * File Name :  RecipeViewModel.kt
 * ClassName :  RecipeViewModel
 * Module Name : app
 * Desc : RecipeViewModel fetch data from RecipeUseCases class
 * Handle success and Error  response from the Repository.
 */

class RecipeViewModel constructor(private val useCase: RecipeUseCases) : BaseViewModel() {

    private var recipeList: MutableLiveData<List<RecipeData>> = MutableLiveData()
    fun recipeData() = recipeList

    /**
     * method call the loadRecipeList
     */
    init {
        loadRecipeList()
    }

    /**
     *Api request and response Handling method
     * load data.
     */
    internal fun loadRecipeList() {
        viewModelScope.launch {
            when (val result = useCase.getRecipesList()) {
                is Result.Success -> {
                    val data = result.data.map(RecipeDomainModel::toPresenter)
                    recipeList.value = data
                }
                is Result.Error -> {
                    errorMessage.postValue(result.data)
                }
            }
            isLoading.set(false)
        }
    }

    /**
     *Api request and response Handling method
     * load data.
     */
    internal fun loadRecipeSearchList(searchQuery: String) {
        viewModelScope.launch {
            when (val result = useCase.getSearchRecipesList(searchQuery)) {
                is Result.Success -> {
                    val data = result.data.map(RecipeDomainModel::toPresenter)
                    recipeList.value = data
                }
                is Result.Error -> {
                    errorMessage.postValue(result.data)
                }
            }
            isLoading.set(false)
        }
    }
}
