package com.sebastiancorradi.yape.di.modules

import com.sebastiancorradi.yape.domain.detailsscreen.InitDetailsScreenUseCase
import com.sebastiancorradi.yape.domain.mainscreen.AboutClickedUseCase
import com.sebastiancorradi.yape.domain.mainscreen.GetRecipesUseCase
import com.sebastiancorradi.yape.domain.mainscreen.ReceipesRequestedUseCase
import com.sebastiancorradi.yape.domain.mainscreen.SearchValueChangedUseCase
import com.sebastiancorradi.yape.domain.mapscreen.InitMapScreenUseCase
import com.sebastiancorradi.yape.domain.mapscreen.ZoomEnabledUseCase
import com.sebastiancorradi.yape.repository.IRecipeRepository
import com.sebastiancorradi.yape.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object MainScreenModule {
    @Provides
    fun provideAboutClickedUseCase() = AboutClickedUseCase()

    @Provides
    fun provideRecipeRepository():IRecipeRepository = RecipeRepository()

    @Provides
    fun provideInitDetailsScreenUseCase(): InitDetailsScreenUseCase{
        return InitDetailsScreenUseCase()
    }

    @Provides
    fun provideInitMapScreenUseCase() = InitMapScreenUseCase()

    @Provides
    fun provideZoomEnabledUseCase() = ZoomEnabledUseCase()

    @Provides
    fun provideSearchValueChangedUseCase() = SearchValueChangedUseCase()

    @Provides
    fun providesGetRecipesUseCase(iRecipeRepository: IRecipeRepository) = GetRecipesUseCase(iRecipeRepository)

    @Provides
    fun provideRecipesRequestedUseCase(getRecipesUseCase: GetRecipesUseCase) = ReceipesRequestedUseCase(getRecipesUseCase)
}