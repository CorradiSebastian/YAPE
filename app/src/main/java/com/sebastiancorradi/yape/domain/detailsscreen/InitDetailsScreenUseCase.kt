package com.sebastiancorradi.yape.domain.detailsscreen

import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.ui.details.DetailsScreenUIState
import javax.inject.Inject

class InitDetailsScreenUseCase @Inject constructor(
) {
    operator fun invoke(recipe: Recipe): DetailsScreenUIState {
        val result = DetailsScreenUIState(
            name = recipe.name?:"",
            description = recipe.description?:"",
            ingredients = recipe.ingredients?:"",
            latitude = recipe.latitude?:0.0,
            longitude = recipe.longitude?:0.0,
            image = recipe.image?:""
        )

        return result;
    }
}