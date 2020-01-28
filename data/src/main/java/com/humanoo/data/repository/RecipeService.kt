package com.humanoo.data.repository

import com.humanoo.data.endpoints.EndpointPaths
import com.humanoo.data.model.RecipesApiResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RecipeService {

    @GET(EndpointPaths.Recipes.BASE)
    suspend fun getRecipeList(): Response<RecipesApiResponseModel>

    @GET(EndpointPaths.Recipes.INGREDIENT)
    suspend fun searchRecipesByIngredient(@Query(EndpointPaths.Params.INGREDIENTS) ingredient: String): Response<RecipesApiResponseModel>

}