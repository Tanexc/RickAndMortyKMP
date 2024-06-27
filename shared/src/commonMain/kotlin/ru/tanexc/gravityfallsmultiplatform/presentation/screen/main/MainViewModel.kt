package ru.tanexc.gravityfallsmultiplatform.presentation.screen.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.Screen
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.UIState

class MainViewModel: ViewModel() {
    val state: StateFlow<UIState> = MutableStateFlow(UIState.Loading)
    private val _currentScreen: MutableState<Screen> = mutableStateOf(Screen.Catalog)
    val currentScreen by _currentScreen




}