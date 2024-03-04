package com.sebastiancorradi.yape.ui.details

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.test.junit4.createComposeRule
import com.sebastiancorradi.yape.data.Recipe
import com.sebastiancorradi.yape.domain.mapscreen.ZoomEnabledUseCase
import com.sebastiancorradi.yape.ui.details.DetailsViewModel
import com.sebastiancorradi.yape.ui.map.MapScreenUIState
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class DetailsViewModelTest {

    @get:Rule
    val rule = createComposeRule()
    @Test
    fun initTest() = runTest {
        //rule.setContent { DetailsScreen(seeItInMapsClicked = {}) }
    }
}