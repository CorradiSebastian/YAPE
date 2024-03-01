package com.sebastiancorradi.yape.domain.mainscreen

import com.sebastiancorradi.yape.ui.main.MainScreenUIState
import javax.inject.Inject

class ReceipesRequestedUseCase @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase,
) {
    suspend operator fun invoke(state: MainScreenUIState): MainScreenUIState {
        val recipes = getRecipesUseCase()
        return state.copy(recipes = recipes, filteredRecipes = recipes)
    }
}

