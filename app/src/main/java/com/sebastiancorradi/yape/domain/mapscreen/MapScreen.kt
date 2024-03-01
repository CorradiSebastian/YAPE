package com.sebastiancorradi.yape.domain.mapscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.sebastiancorradi.yape.R
import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.ui.details.DetailsViewModel
import com.sebastiancorradi.yape.ui.theme.YAPETheme

@Composable
fun MapScreen(
recipe: Recipe? = null,
//onMapClicked:(recipe: Recipe) -> Unit,
//detailsViewModel: DetailsViewModel = viewModel(),
) {
    Text(text = "Map, receipe: $recipe")
}
