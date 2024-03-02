package com.sebastiancorradi.yape.repository

import com.sebastiancorradi.yape.datasource.RecipeResponse

interface IRecipeRepository {
    suspend fun getRecipes(): RecipeResponse
}