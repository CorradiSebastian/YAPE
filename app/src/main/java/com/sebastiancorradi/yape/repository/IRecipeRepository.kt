package com.sebastiancorradi.yape.repository

import com.sebastiancorradi.yape.datasource.data.RecipeResponse

interface IRecipeRepository {
    suspend fun getRecipes(): RecipeResponse
}