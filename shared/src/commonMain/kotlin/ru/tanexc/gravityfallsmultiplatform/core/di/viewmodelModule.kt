package ru.tanexc.gravityfallsmultiplatform.core.di

import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.dsl.module
import ru.tanexc.gravityfallsmultiplatform.presentation.screen.catalog.CatalogViewModel
import ru.tanexc.gravityfallsmultiplatform.presentation.screen.main.MainViewModel

val viewmodelModule = module {
    single { CatalogViewModel(get()) }
    single { MainViewModel() }
}