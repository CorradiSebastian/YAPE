package com.sebastiancorradi.yape.domain.mainscreen

import com.sebastiancorradi.yape.ui.main.MainScreenUIState

class AboutClickedUseCase {

    operator fun invoke(state: MainScreenUIState, clicked:Boolean):MainScreenUIState {
        if (state.displayingAbout != clicked)
        {
            return state.copy(displayingAbout = clicked)
        }
        return state
    }
}