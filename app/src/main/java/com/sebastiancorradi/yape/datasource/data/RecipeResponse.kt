package com.sebastiancorradi.yape.datasource.data

import com.sebastiancorradi.yape.data.Recipe

class RecipeResponse(val success:Boolean? = null,
                     val errorCode: Int? = null,
                     val recipes: List<Recipe>? = null) {

}