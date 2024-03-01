package com.sebastiancorradi.yape.domain.mapscreen

import com.google.android.gms.maps.model.LatLng
import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.ui.details.DetailsScreenUIState
import com.sebastiancorradi.yape.ui.map.MapScreenUIState
import javax.inject.Inject

class InitMapScreenUseCase @Inject constructor(
) {
    operator fun invoke(recipe: Recipe): MapScreenUIState {
        val location = LatLng(recipe.latitude?:0.0, recipe.longitude?:0.0)
        return MapScreenUIState(location = location, name = recipe.name?:"")
    }
}