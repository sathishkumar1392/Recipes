package com.humanoo.recipes.di

import com.humanoo.domain.usecases.RecipeUseCases
import com.humanoo.domain.usecases.RecipeUseCasesImpl
import com.humanoo.recipes.presentation.recipe.adapter.RecipeItemRecyclerViewAdapter
import com.humanoo.recipes.presentation.recipe.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020 
 * File Name : RecipeModule.kt
 * ClassName : RecipeModule
 * Module Name : app
 * Desc : RecipeModule provides di
 *
 */

val RecipeModule = module {

    single{RecipeUseCasesImpl(get())}.bind(RecipeUseCases::class)
    viewModel {RecipeViewModel( get())}
    factory { RecipeItemRecyclerViewAdapter() }
}