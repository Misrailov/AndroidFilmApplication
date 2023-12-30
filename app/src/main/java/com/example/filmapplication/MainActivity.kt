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
import com.example.filmapplication.screens.FilmApp
import com.example.filmapplication.screens.utils.FilmApplicationNavigationType
import com.example.filmapplication.ui.theme.EntertainmentApplicationTheme

/**
 * The main activity of the Film Application.
 */
class MainActivity : ComponentActivity() {

    /**
     * Called when the activity is starting.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being
     * shut down, this Bundle contains the data it most recently supplied in
     * [onSaveInstanceState]. Otherwise, it is null.
     */
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EntertainmentApplicationTheme {
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
