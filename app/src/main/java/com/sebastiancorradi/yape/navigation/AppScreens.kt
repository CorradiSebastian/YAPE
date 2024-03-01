package com.sebastiancorradi.yape.navigation

enum class Screen {
    MAIN,
    DETAILS,
    MAP
}
sealed class NavigationItem(val route: String) {
    object Main : NavigationItem(Screen.MAIN.name)
    object Details : NavigationItem(Screen.DETAILS.name + "/{recipe}")
    object Map : NavigationItem(Screen.MAP.name + "/{recipe}")
}