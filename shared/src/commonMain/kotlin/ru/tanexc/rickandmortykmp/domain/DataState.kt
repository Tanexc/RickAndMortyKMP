package ru.tanexc.rickandmortykmp.domain

sealed class DataState<out T> {
    data object Loading: DataState<Nothing>()

    data object Error: DataState<Nothing>()

    data class Success<T>(val data: T): DataState<T>()
}