package com.sebastiancorradi.yape.ui.map

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.domain.detailsscreen.InitDetailsScreenUseCase
import com.sebastiancorradi.yape.domain.mapscreen.InitMapScreenUseCase
import com.sebastiancorradi.yape.domain.mapscreen.ZoomEnabledUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(): ViewModel() {

    @Inject
    public lateinit var initMapScreenUseCase: InitMapScreenUseCase

    @Inject
    lateinit var zoomEnabledUseCase: ZoomEnabledUseCase

    private val _mapScreenUIState = MutableStateFlow(MapScreenUIState())
    val mapScreenUIState: StateFlow<MapScreenUIState> = _mapScreenUIState.asStateFlow()

    fun init(recipe: Recipe){
        _mapScreenUIState.value = initMapScreenUseCase(recipe)
    }

    fun zoomEnabled(zoomEnabled:Boolean) {
        _mapScreenUIState.value = zoomEnabledUseCase(_mapScreenUIState.value, zoomEnabled)
    }
}