package com.sebastiancorradi.yape.usecasestest

import com.sebastiancorradi.yape.domain.mapscreen.ZoomEnabledUseCase
import com.sebastiancorradi.yape.ui.map.MapScreenUIState
import org.junit.Assert
import org.junit.Test

class UseCasesTests {
    @Test
    fun zoomEnabledUseCaseTest() {
        val zoomEnabledUseCase = ZoomEnabledUseCase()
        val state = MapScreenUIState(zoomEnabled = true)
        val stateTrue = zoomEnabledUseCase(state, true)
        val stateFalse = zoomEnabledUseCase(state, false)
        Assert.assertTrue(stateTrue.zoomEnabled)
        Assert.assertFalse(stateFalse.zoomEnabled)
        Assert.assertEquals(stateTrue, zoomEnabledUseCase(stateTrue, true))
        Assert.assertEquals(stateFalse, zoomEnabledUseCase(stateTrue, false))
    }


}