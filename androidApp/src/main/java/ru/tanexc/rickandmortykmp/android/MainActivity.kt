package ru.tanexc.rickandmortykmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.tanexc.rickandmortykmp.presentation.screen.main.GravityFallsApp
import ru.tanexc.rickandmortykmp.presentation.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                GravityFallsApp()
            }
        }
    }
}