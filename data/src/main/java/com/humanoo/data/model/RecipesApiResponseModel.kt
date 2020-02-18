package com.humanoo.data.model

import com.google.gson.annotations.SerializedName

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020
 * File Name : RecipesApiResponseModel.kt
 * ClassName : RecipesApiResponseModel
 * Module Name : app
 * Desc : RecipesApiResponseModel
 */

data class RecipesApiResponseModel(
    @SerializedName("href")
    val href: String = "", // http://www.recipepuppy.com/
    @SerializedName("results")
    val results: List<Result> = listOf(),
    @SerializedName("title")
    val title: String = "", // Recipe Puppy
    @SerializedName("version")
    val version: Double = 0.0 // 0.1
)

data class Result(
    @SerializedName("href")
    val href: String = "", // http://www.recipezaar.com/Boiled-Ham-11162
    @SerializedName("ingredients")
    val ingredients: String = "", // ham, onions
    @SerializedName("thumbnail")
    val thumbnail: String = "", // http://img.recipepuppy.com/182730.jpg
    @SerializedName("title")
    val title: String = "" // Boiled Ham
)