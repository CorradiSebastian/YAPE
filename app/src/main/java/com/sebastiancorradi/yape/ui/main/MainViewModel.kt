package com.sebastiancorradi.yape.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebastiancorradi.yape.domain.mainscreen.AboutClickedUseCase
import com.sebastiancorradi.yape.domain.mainscreen.ReceipesRequestedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var aboutClickedUseCase: AboutClickedUseCase

    @Inject
    lateinit var receipesRequestedUseCase: ReceipesRequestedUseCase

    private val _mainScreenUIState = MutableStateFlow(MainScreenUIState())
    val mainScreenUIState: StateFlow<MainScreenUIState> = _mainScreenUIState.asStateFlow()

    fun receipeRequested() {
        viewModelScope.launch(Dispatchers.IO) {
            _mainScreenUIState.value =
                _mainScreenUIState.value.copy(recipes = receipesRequestedUseCase())
        }
    }


}