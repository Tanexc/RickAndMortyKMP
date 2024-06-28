package ru.tanexc.gravityfallsmultiplatform.presentation.screen.main

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.tanexc.gravityfallsmultiplatform.domain.repository.CharacterRepository
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.Screen
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.TopBarState
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.UIState

class MainViewModel: ViewModel() {
    private val _currentScreen: MutableState<Screen> = mutableStateOf(Screen.Catalog)
    val currentScreen by _currentScreen

    private val _topBarState: MutableState<TopBarState> = mutableStateOf(TopBarState.default())
    val topBarState by _topBarState

    fun updateCurrentScreen(screen: Screen) {
        _currentScreen.value = screen
    }

    fun updateTopBarState(
        title: @Composable () -> Unit = topBarState.title,
        navigationIcon: @Composable () -> Unit = topBarState.navigationIcon,
        actions: @Composable RowScope.() -> Unit = topBarState.actions
    ) {
        _topBarState.value = topBarState.copy(
            title = title,
            navigationIcon = navigationIcon,
            actions = actions
        )
    }


}