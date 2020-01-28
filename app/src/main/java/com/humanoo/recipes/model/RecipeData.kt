package com.humanoo.recipes.model

import android.os.Parcelable
import com.humanoo.domain.model.RecipeDomainModel
import kotlinx.android.parcel.Parcelize

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020 
 * File Name : RecipeData.kt
 * ClassName : RecipeData
 * Module Name : app
 * Desc : RecipeData Model class
 */

@Parcelize
data class RecipeData(
    val href: String = "",
    val ingredients: String = "",
    val thumbnail: String = "",
    val title: String = ""
) : Parcelable

fun RecipeDomainModel.toPresenter(): RecipeData {
    return RecipeData(href, ingredients, thumbnail, title)
}
