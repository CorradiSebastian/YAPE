package com.sebastiancorradi.yape.domain.mainscreen

import android.util.Log
import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.repository.RecipeRepository
import javax.inject.Inject

class ReceipesRequestedUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {
    suspend operator fun invoke(): List<Recipe> {
        val result = recipeRepository.getRecipes().recipes
        Log.e("Sebas", "result: ${result.toString()}")
        return result?: listOf()
    }
}

