package com.sebastiancorradi.yape.ui.map

import com.google.android.gms.maps.model.LatLng

data class MapUIState(
    var locations: List<LatLng> = emptyList<LatLng>(),
)