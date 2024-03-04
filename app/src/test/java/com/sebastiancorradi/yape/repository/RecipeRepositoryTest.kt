package com.sebastiancorradi.yape.repository

import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.datasource.data.RecipeResponse


class RecipeRepositoryTest : IRecipeRepository {
    override suspend fun getRecipes(): RecipeResponse {

        val recipes = getRecipesList()

        val recipesResponse = RecipeResponse(success = true, errorCode = 200, recipes = recipes)
        return recipesResponse
    }

    fun getRecipesList(): List<Recipe> {

        val recipes = mutableListOf<Recipe>()
        recipes.add(Recipe("flan", "es un flan", latitude = -15.0, longitude = -34.0))
        recipes.add(Recipe("torta", "es una torta", latitude = -11.0, longitude = 16.0))
        recipes.add(Recipe("pollo", "es un pollo", latitude = 4.0, longitude = -14.0))

        return recipes
    }
}