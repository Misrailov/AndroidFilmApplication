package com.example.filmapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.example.compose.EntertainmentApplicationTheme
import com.example.filmapplication.screens.FilmApp
import com.example.filmapplication.screens.utils.FilmApplicationNavigationType

class MainActivity : ComponentActivity() {

    companion object { // makes the variables accessible from other files in the project
        var primaryColor: Int = 0
        var secondaryColor: Int = 0
    }

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Initialize the colors here

        setContent {
            EntertainmentApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val windowSize = calculateWindowSizeClass(this)

                    when (windowSize.widthSizeClass) {
                        WindowWidthSizeClass.Compact -> {
                            FilmApp(FilmApplicationNavigationType.BOTTOM_NAVIGATION)
                        }

                        WindowWidthSizeClass.Medium -> {
                            FilmApp(FilmApplicationNavigationType.NAVIGATION_RAIL)
                        }

                        WindowWidthSizeClass.Expanded -> {
                            FilmApp(navigationType = FilmApplicationNavigationType.PERMANENT_NAVIGATION_DRAWER)
                        }

                        else -> {
                            FilmApp(navigationType = FilmApplicationNavigationType.BOTTOM_NAVIGATION)
                        }
                    }
                }
            }
        }
    }
}
