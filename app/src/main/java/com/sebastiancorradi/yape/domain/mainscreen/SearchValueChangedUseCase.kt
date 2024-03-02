package com.sebastiancorradi.yape.domain.mainscreen

import com.sebastiancorradi.yape.ui.main.MainScreenUIState

class SearchValueChangedUseCase() {
    operator fun invoke(
        state: MainScreenUIState,
        newValue: String,
    ): MainScreenUIState {
        return if (newValue.equals(state.searchValue)) {
            state
        } else {
            val list = state.recipes
            val filteredList = list.filter { it.name?.contains(newValue)?:false || it.ingredients?.contains(newValue)?:false }
            state.copy(searchValue = newValue, filteredRecipes = filteredList)
        }
    }
}