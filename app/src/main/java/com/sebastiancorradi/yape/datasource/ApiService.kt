package com.sebastiancorradi.yape.datasource

import com.sebastiancorradi.yape.datasource.data.RecipeResponse
import retrofit2.http.GET

interface ApiService {

    @GET("receipes")
    suspend fun getRecipes(): RecipeResponse?
}
