package ru.tanexc.rickandmortykmp.core.di

import org.koin.dsl.module
import ru.tanexc.rickandmortykmp.presentation.screen.catalog.CatalogViewModel
import ru.tanexc.rickandmortykmp.presentation.screen.main.MainViewModel

val viewmodelModule = module {
    single { CatalogViewModel(get()) }
    single { MainViewModel() }
}