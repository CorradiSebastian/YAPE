package com.sebastiancorradi.yape.datasource

import retrofit2.http.GET

interface ApiService {

    @GET("receipes")
    suspend fun getRecipes(): RecipeResponse?
}
