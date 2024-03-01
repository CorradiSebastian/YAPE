package com.sebastiancorradi.yape.ui.map

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.currentCameraPositionState
import com.sebastiancorradi.yape.data.Recipe


private lateinit var state:MapScreenUIState
private lateinit var _viewModel: MapViewModel

@SuppressLint("RememberReturnType")
@Composable
fun MapScreen(recipe: Recipe, viewModel: MapViewModel = hiltViewModel()) {


    state = viewModel.mapScreenUIState.collectAsState().value
    val context = LocalContext.current
    _viewModel = viewModel
    remember() {
        viewModel.init(recipe)
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (row1, text) = createRefs()

        Row(modifier = Modifier.constrainAs(row1) {
            top.linkTo(parent.top, margin = 5.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Text("Hello")
        }

        ShowMap(state.location, state.name)
    }
}


@Composable
fun ShowMap(location: LatLng, name: String){
    var uiSettings by remember { mutableStateOf(MapUiSettings()) }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = properties,
        uiSettings = uiSettings,
        //cameraPositionState =  cameraPositionState,
    ){

            location?.let {
                Marker(
                    state = MarkerState(
                        position = LatLng(
                            it.latitude?:0.0,
                            it.longitude?:0.0
                        )
                    ), title = name
                )
            }

                var cameraPosition = CameraPosition.fromLatLngZoom(LatLng(location.latitude, location.longitude), 10f)
                val recipeCameraPosition = CameraPositionState(cameraPosition)

            currentCameraPositionState.move(
                CameraUpdateFactory.newCameraPosition(
                    recipeCameraPosition.position
                )
            )
            currentCameraPositionState.move(CameraUpdateFactory.zoomTo(4F))

    }
    Column {
        SwitchWithText(label = "Zoom enabled", callback = { checked ->
            uiSettings = uiSettings.copy(zoomControlsEnabled = checked,
                scrollGesturesEnabled = checked,
                zoomGesturesEnabled = checked,
                rotationGesturesEnabled = checked,)
            _viewModel.zoomEnabled(checked, )
        }, _viewModel.mapScreenUIState.collectAsState().value.zoomEnabled)
    }
}

@Composable
fun BasicSwitch(callback: (checked: Boolean) -> Unit, checked: Boolean) {
    Switch(
        checked = checked,
        onCheckedChange = {
            callback(it)
        },
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        }
    )
}

@Composable
fun SwitchWithText(label: String, callback: (checked: Boolean) -> Unit, checked: Boolean) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentWidth()
                .background(Color(0x80000000))
                .padding(horizontal = 5.dp),
        ) {
            Text(text =  label, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(5.dp))
            BasicSwitch(callback, checked)
        }
    }
}