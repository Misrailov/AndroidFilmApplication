package com.example.filmapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.example.filmapplication.screens.FilmApp
import com.example.filmapplication.ui.theme.EntertainmentApplicationTheme

class MainActivity : ComponentActivity() {

    companion object { // makes the variables accessible from other files in the project
        var primaryColor: Int = 0
        var secondaryColor: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Initialize the colors here
        primaryColor = ContextCompat.getColor(this, R.color.colorPrimary)
        secondaryColor = ContextCompat.getColor(this, R.color.colorSecondary)

        setContent {
            EntertainmentApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    FilmApp("Android")
                }
            }
        }
    }
}
