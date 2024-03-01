package com.sebastiancorradi.yape.ui.main

import com.sebastiancorradi.yape.data.Recipe

data class MainScreenUIState(
    var displayingAbout:Boolean = false,
    var recipes: List<Recipe> = listOf(),
    var filteredRecipes: List<Recipe> = listOf(),
    val searchValue: String = ""
    )