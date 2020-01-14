package com.humanoo.data.endpoints

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020
 * File Name : RecipeDetailsFragment.kt
 * ClassName : RecipeDetailsFragment
 * Module Name : app
 * Desc : RecipeDetailsFragment class show the details of Selected recipe.
 */

object EndpointPaths {

    object Recipes {
        const val BASE = "api/"
        const val INGREDIENT = "$BASE?"
    }


    object Params {
        const val INGREDIENTS = "i"
    }
}