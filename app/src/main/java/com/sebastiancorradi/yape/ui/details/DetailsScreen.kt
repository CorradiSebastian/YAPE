package com.sebastiancorradi.yape.ui.details

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.sebastiancorradi.yape.R
import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.ui.theme.YAPETheme

@Composable
fun DetailsScreen(
    recipe: Recipe? = null,
    //onMapClicked:(recipe: Recipe) -> Unit,
    seeItInMapsClicked:(recipe: Recipe) -> Unit,
    detailsViewModel: DetailsViewModel = viewModel(),
    ) {
    YAPETheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            DetailsContent(recipe, detailsViewModel, seeItInMapsClicked)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsContent(
    recipe: Recipe?,
    viewModel: DetailsViewModel,
    seeItInMapsClicked:(recipe: Recipe) -> Unit,
) {
    val context = LocalContext.current
    val state = viewModel.detailsScreenUIState.collectAsState()
    recipe?.let {
        viewModel.init(it)
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text("Name: ${state.value.name}")
            Text("Description: ${state.value.description}")
            Text("Ingredients: ${state.value.ingredients}")
            GlideImage(
                model = state.value.image,
                contentDescription = context.getString(R.string.image),
                modifier = Modifier.padding(2.dp).clickable(onClick = {  }).size(200.dp),
            )
            Button(modifier = Modifier.wrapContentSize(), onClick = {
                seeItInMapsClicked(Recipe(latitude = state.value.latitude, longitude = state.value.longitude))
            }) {
                Text(text = context.getString(R.string.see_it_in_map))
            }
        }
    }
}
