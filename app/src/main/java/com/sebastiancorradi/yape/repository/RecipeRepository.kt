package com.sebastiancorradi.yape.repository

import com.sebastiancorradi.yape.datasource.ApiClient
import com.sebastiancorradi.yape.datasource.RecipeResponse




class RecipeRepository() : IRecipeRepository {
    override suspend fun getRecipes(): RecipeResponse {
        /*
        val result = mutableListOf<Receipe>()
        result.add(Receipe("flan", "es un flan", location = LatLng(-15.0, -34.0)))
        result.add(Receipe("torta", "es una torta", location = LatLng(-18.996, -36.02)))
        result.add(Receipe("Apple Crumble", "es un", location = LatLng(-15.0, -34.0)))
    */
        val response = ApiClient.apiService.getRecipes()
        val result = response
        return result?:RecipeResponse()
    }
}