package com.sebastiancorradi.yape.navigation

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.ui.details.DetailsScreen
import com.sebastiancorradi.yape.ui.details.DetailsViewModel
import com.sebastiancorradi.yape.ui.main.MainScreen
import com.sebastiancorradi.yape.ui.main.MainViewModel
import com.sebastiancorradi.yape.ui.map.MapScreen
import com.sebastiancorradi.yape.ui.map.MapViewModel


private lateinit var _navController: NavController
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Main.route,
) {
    _navController = navController
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        composable(NavigationItem.Main.route) {
            MainScreen(::navigateTodetails, mainViewModel = hiltViewModel<MainViewModel>())
        }

        composable(NavigationItem.Details.route, arguments = listOf(navArgument("recipe"){
            type = AssetParamType()
        })) {
                backStackEntry ->
            val recipe = backStackEntry.arguments?.getParcelable<Recipe>("recipe")
            Log.e("Sebas", "en el baile, recipe: $recipe")

            DetailsScreen(recipe, detailsViewModel = hiltViewModel<DetailsViewModel>(), seeItInMapsClicked = ::navigateToMap)
        }
        composable(NavigationItem.Map.route, arguments = listOf(navArgument("recipe"){
            type = AssetParamType()
        })) {
                backStackEntry ->
            val recipe = backStackEntry.arguments?.getParcelable<Recipe>("recipe")

            MapScreen(recipe?: Recipe(), viewModel = hiltViewModel<MapViewModel>(),)
        }
    }
}

fun navigateTodetails(recipe: Recipe){
    Log.e("sebas", "reipe: $recipe")
    val json = Uri.encode(Gson().toJson(recipe))
    _navController.navigate("DETAILS/$json")
}

fun navigateToMap(recipe: Recipe){
    Log.e("sebas", "reipe: $recipe")
    val json = Uri.encode(Gson().toJson(recipe))
    _navController.navigate("MAP/$json")
}
class AssetParamType : NavType<Recipe>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Recipe? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Recipe {
        return Gson().fromJson(value, Recipe::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Recipe) {
        bundle.putParcelable(key, value)
    }
}