package com.sebastiancorradi.yape.repository

import android.util.Log
import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.datasource.ApiClient
import com.sebastiancorradi.yape.datasource.data.RecipeResponse
import retrofit2.HttpException


class RecipeRepository() : IRecipeRepository {
    override suspend fun getRecipes(): RecipeResponse {
        var response:RecipeResponse? = RecipeResponse()
        try {
            response = ApiClient.apiService.getRecipes()
        } catch (e: HttpException){
            Log.e("sebas", "Exception: $e")

            val recipes = mutableListOf<Recipe>()
            recipes.add(Recipe("flan", "es un flan", latitude = -15.0, longitude = -34.0, ingredients = "harina, agua"))
            recipes.add(Recipe("torta", "es una torta", latitude = -11.0, longitude = 16.0, ingredients = "harina, pan"))
            recipes.add(Recipe("pollo", "es un pollo", latitude = 4.0, longitude = -14.0, ingredients = "jamon, queso"))

            response = RecipeResponse(errorCode = 200, success = true, recipes = recipes)

        }

        return response?: RecipeResponse()
    }
}