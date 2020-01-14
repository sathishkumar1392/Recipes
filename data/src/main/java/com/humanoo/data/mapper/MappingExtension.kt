package com.humanoo.data.mapper

import com.humanoo.data.model.Result
import com.humanoo.domain.model.RecipeDomainModel

/*
 * Project Name : Recipes
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-01-2020
 * File Name : MappingExtension.kt
 * ClassName : MappingExtension
 * Module Name : app
 * Desc : Mapping the Result to
 * domain model
 */

fun Result.toDomain(): RecipeDomainModel {
    return RecipeDomainModel(href,ingredients,thumbnail,title)
}
