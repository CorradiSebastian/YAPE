package com.sebastiancorradi.yape.ui.map

import com.google.android.gms.maps.model.LatLng

data class MapScreenUIState(
    var location: LatLng = LatLng(0.0, 0.0),
    var name: String = "",
    var zoomEnabled: Boolean = true,
)