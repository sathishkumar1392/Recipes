package com.humanoo.domain.model

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020
 * File Name : RecipeDomainModel.kt
 * ClassName : RecipeDomainModel
 * Module Name : app
 * Desc : RecipeDomainModel class
 */

data class RecipeDomainModel(
    val href: String = "",
    val ingredients: String = "",
    val thumbnail: String = "",
    val title: String = "")
