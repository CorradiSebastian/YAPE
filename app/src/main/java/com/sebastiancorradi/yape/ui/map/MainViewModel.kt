package com.sebastiancorradi.yape.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(): ViewModel() {


    private lateinit var _dbLocationsFlow: Flow<List<LatLng>>



    private val _mapUIState = MutableStateFlow(MapUIState())

    val mapUIState: StateFlow<MapUIState> = _mapUIState.asStateFlow()

    fun init(lat:Double, lon:Double){

    }
    /*fun getDBLocationsFlow(): Flow<List<LatLng>> {
        _dbLocationsFlow = getDBLocationsUseCase(deviceId)
        viewModelScope.launch {
            _dbLocationsFlow.collect { locations ->
                _mapUIState.value = mapUIState.value.copy(locations = locations)// Update DB, add latest location
            }
        }
        return _dbLocationsFlow
    }*/



   /* fun zoomEnabled(zoomEnabled:Boolean) {
        _mapUIState.value = zoomEnabledUseCase(_mapUIState.value, zoomEnabled)
    }*/
}