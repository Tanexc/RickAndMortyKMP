package ru.tanexc.gravityfallsmultiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.tanexc.gravityfallsmultiplatform.presentation.screen.main.GravityFallsApp
import ru.tanexc.gravityfallsmultiplatform.presentation.ui.theme.AppTheme

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