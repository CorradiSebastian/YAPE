package com.sebastiancorradi.yape.usecasestest

import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.domain.mainscreen.GetRecipesUseCase
import com.sebastiancorradi.yape.domain.mainscreen.SearchValueChangedUseCase
import com.sebastiancorradi.yape.domain.mapscreen.InitMapScreenUseCase
import com.sebastiancorradi.yape.domain.mapscreen.ZoomEnabledUseCase
import com.sebastiancorradi.yape.repository.IRecipeRepository
import com.sebastiancorradi.yape.repository.RecipeRepositoryTest
import com.sebastiancorradi.yape.ui.main.MainScreenUIState
import com.sebastiancorradi.yape.ui.map.MapScreenUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

class UseCasesTests{

    @Test
    fun zoomEnabledUseCaseTest() {
        val zoomEnabledUseCase = ZoomEnabledUseCase()
        val state = MapScreenUIState(zoomEnabled = true)
        val stateTrue = zoomEnabledUseCase(state, true)
        val stateFalse = zoomEnabledUseCase(state, false)
        Assert.assertTrue(stateTrue.zoomEnabled)
        Assert.assertFalse(stateFalse.zoomEnabled)
        Assert.assertEquals(stateTrue, zoomEnabledUseCase(stateTrue, true))
        Assert.assertEquals(stateFalse, zoomEnabledUseCase(stateTrue, false))
    }

    @Test
    fun initMapScreenUseCaseTest() {
        val initMapScreenUseCase = InitMapScreenUseCase()
        val recipe = Recipe(latitude = 12.0, longitude = 13.0, name = "prueba")
        val newState = initMapScreenUseCase(recipe)
        Assert.assertEquals(recipe.latitude, newState.location.latitude)
        Assert.assertEquals(recipe.longitude, newState.location.longitude)
        Assert.assertEquals(recipe.name, newState.name)
    }

    @Test
    fun searchValueChangedUseCaseTest() {
        val searchValueChangedUseCase = SearchValueChangedUseCase()
        val state = MainScreenUIState(recipes = getRecipes(), filteredRecipes = getRecipes())

        val twoResultsSearch = searchValueChangedUseCase(state, "recipe")
        val oneResultSearch = searchValueChangedUseCase(state, "jamon")
        val emptyResultSearch = searchValueChangedUseCase(state, "jamones")
        val fullResultSearch = searchValueChangedUseCase(state, "")

        Assert.assertEquals(2, twoResultsSearch.filteredRecipes.size)
        Assert.assertEquals(1, oneResultSearch.filteredRecipes.size)
        Assert.assertEquals(0, emptyResultSearch.filteredRecipes.size)
        Assert.assertEquals(4, fullResultSearch.filteredRecipes.size)
    }

   @Test
    fun getRecipesUseCaseTest() = runTest {
            val recipeRepository = RecipeRepositoryTest()
            val getRecipesUseCase = GetRecipesUseCase(recipeRepository = recipeRepository)
            val recipes = getRecipesUseCase()
            val repository = RecipeRepositoryTest()
            val expectedRecipes = repository.getRecipesList()
            Assert.assertEquals(expectedRecipes, recipes)
        }

    private fun getRecipes(): List<Recipe>{
        val result = mutableListOf<Recipe>()
        result.add(Recipe("recipe1", ingredients = "harina, agua"))
        result.add(Recipe("recipe2", ingredients = "sal, agua"))
        result.add(Recipe("nombre1",ingredients = "pan, jamon, queso"))
        result.add(Recipe("nombre2", ingredients = "soja, manzana"))
        return result
    }


}