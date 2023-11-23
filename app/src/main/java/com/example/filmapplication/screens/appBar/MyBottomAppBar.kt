package com.example.filmapplication.screens.appBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.filmapplication.screens.primaryColor
import com.example.filmapplication.screens.secondaryColor

@Composable
fun MyBottomBar(
    OnHome: () -> Unit,
    OnMovie: () -> Unit,
    OnSerie : () -> Unit,
    OnActor: () -> Unit,

){
    Text(text = "navbar")
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor =  Color.Black,
        modifier = Modifier.height(56.dp),
        actions = {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                IconButton(onClick = OnHome) {
                    Icon(Icons.Outlined.Home, contentDescription = "Localized description")
                }
                IconButton(onClick = OnMovie) {
                    Icon(Icons.Outlined.CalendarMonth, contentDescription = "Localized description")
                }
                IconButton(onClick = OnSerie) {
                    Icon(
                        Icons.Outlined.Newspaper,
                        contentDescription = "Localized description",
                    )
                }
                IconButton(onClick = OnActor) {
                    Icon(
                        Icons.Outlined.Visibility,
                        contentDescription = "Localized description",
                    )
                }

            }
        }
    )
}

