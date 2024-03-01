package com.sebastiancorradi.yape.ui.main

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.ui.components.ReceipeCard
import com.sebastiancorradi.yape.ui.theme.YAPETheme
import kotlin.reflect.KFunction2

val TAG = "MainScreen"

@Composable
fun MainScreen(
    onSeeDetailClicked:(recipe: Recipe) -> Unit,
    mainViewModel: MainViewModel = viewModel(),
) {

    val mainScreenUIState by mainViewModel.mainScreenUIState.collectAsState()
    YAPETheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            MainContent(onSeeDetailClicked, mainViewModel)
            if (mainScreenUIState.displayingAbout) {
                displayAbout()
            }
        }
    }
}

fun displayAbout() {
    TODO("Not yet implemented")
}

@Composable
fun MainContent(
    onSeeDetailClicked:(recipe: Recipe) -> Unit,
    //onSeeDetailClicked:() -> Unit,
    viewModel: MainViewModel,
) {
    val state = viewModel.mainScreenUIState.collectAsState()

    val receipes = state.value.recipes
    Log.e(TAG, "receipes value: $receipes")

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
    ) {
        val (recyclerColumn) = createRefs()

        if (receipes?.size == 0){
            Text("loading")
            viewModel.receipeRequested()
        } else {
            LazyColumn(modifier = Modifier.constrainAs(recyclerColumn) {
                top.linkTo(parent.top, margin = 5.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
                items(
                    receipes
                ) {
                    ReceipeCard(onSeeDetailClicked, it)
                }
            }
        }
    }
}
