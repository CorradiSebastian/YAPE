package com.sebastiancorradi.yape.di.modules

import com.sebastiancorradi.yape.domain.detailsscreen.InitDetailsScreenUseCase
import com.sebastiancorradi.yape.domain.mainscreen.AboutClickedUseCase
import com.sebastiancorradi.yape.domain.mainscreen.ReceipesRequestedUseCase
import com.sebastiancorradi.yape.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainScreenModule {
    @Provides
    fun provideAboutClickedUseCase() = AboutClickedUseCase()

    @Provides
    fun provideRecipeRepository() = RecipeRepository()

    @Provides
    fun provideRecipesRequestedUseCase(recipeRepository: RecipeRepository) = ReceipesRequestedUseCase(recipeRepository)

    @Provides
    fun provideInitDetailsScreenUseCase(): InitDetailsScreenUseCase{
        return InitDetailsScreenUseCase()
    }

}