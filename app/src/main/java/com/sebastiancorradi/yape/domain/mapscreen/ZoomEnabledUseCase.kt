package com.sebastiancorradi.yape.domain.mapscreen

import com.sebastiancorradi.yape.ui.map.MapScreenUIState

class ZoomEnabledUseCase {
    operator fun invoke(mapScreenUIState: MapScreenUIState, zoomEnabled: Boolean): MapScreenUIState {
        return if (zoomEnabled != mapScreenUIState.zoomEnabled){
            mapScreenUIState.copy(zoomEnabled = zoomEnabled)
        } else {
            mapScreenUIState
        }
    }

}