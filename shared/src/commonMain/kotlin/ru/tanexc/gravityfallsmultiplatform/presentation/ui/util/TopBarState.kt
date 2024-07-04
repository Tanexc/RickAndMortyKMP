package ru.tanexc.gravityfallsmultiplatform.presentation.ui.util

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

data class TopBarState(
    val title: @Composable () -> Unit,
    val navigationIcon: @Composable () -> Unit,
    val actions: @Composable RowScope.() -> Unit
) {
    companion object {
        fun default() = TopBarState({}, {}, {})
    }
}