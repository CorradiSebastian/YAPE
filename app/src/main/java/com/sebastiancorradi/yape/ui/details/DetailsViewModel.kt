package com.sebastiancorradi.yape.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel

import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.domain.detailsscreen.InitDetailsScreenUseCase
import com.sebastiancorradi.yape.domain.mainscreen.ReceipesRequestedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    @Inject
    public lateinit var initDetailsScreenUseCase: InitDetailsScreenUseCase

    private val _detailsScreenUIState = MutableStateFlow(DetailsScreenUIState())
    val detailsScreenUIState: StateFlow<DetailsScreenUIState> = _detailsScreenUIState.asStateFlow()

    fun init(receipe: Recipe) {
        _detailsScreenUIState.value = initDetailsScreenUseCase(receipe)
    }

    fun seeItInMapsClicked(latitude: Double, longitude: Double) {
        TODO("Not yet implemented")
    }

}

