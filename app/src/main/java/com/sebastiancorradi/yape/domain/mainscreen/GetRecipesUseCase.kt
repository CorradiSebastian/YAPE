package com.sebastiancorradi.yape.domain.mainscreen

import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.repository.IRecipeRepository
import com.sebastiancorradi.yape.repository.RecipeRepository
import com.sebastiancorradi.yape.ui.main.MainScreenUIState
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val recipeRepository: IRecipeRepository,
) {
    suspend operator fun invoke(): List<Recipe> {
        val result = recipeRepository.getRecipes().recipes
        return result?: listOf()
    }
}

