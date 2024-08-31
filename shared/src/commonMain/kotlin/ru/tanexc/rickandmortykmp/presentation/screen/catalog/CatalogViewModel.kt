package ru.tanexc.rickandmortykmp.presentation.screen.catalog

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.tanexc.rickandmortykmp.domain.DataState
import ru.tanexc.rickandmortykmp.domain.model.Character
import ru.tanexc.rickandmortykmp.domain.repository.CharacterRepository
import ru.tanexc.rickandmortykmp.presentation.ui.util.UIState

class CatalogViewModel(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    private val _state: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)
    val state: StateFlow<UIState> = _state

    private val _data: MutableState<List<Character>> = mutableStateOf(emptyList())
    val data by _data

    private val page: MutableStateFlow<Int> = MutableStateFlow(0)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            collectPages()
        }
    }

    private suspend fun collectPages() {
        page.collectLatest { value ->
            characterRepository.getPage(page = value).collect { dataState ->
                when (dataState) {
                    is DataState.Error -> {
                        _state.value = UIState.Error
                    }

                    is DataState.Loading -> {
                        _state.value = UIState.Loading
                    }

                    is DataState.Success -> {
                        _data.value += dataState.data
                        _state.value = UIState.Success
                    }
                }
            }
        }
    }

    fun nextPage() {
        page.value += 1
        _state.value = UIState.Loading
    }
}