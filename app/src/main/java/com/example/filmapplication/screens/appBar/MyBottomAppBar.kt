package com.example.filmapplication.screens.appBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalMovies
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.filmapplication.R
/**
 * A custom BottomAppBar used for navigation within the application.
 *
 * @param OnHome Callback for the Home icon click action.
 * @param OnMovie Callback for the Movie icon click action.
 * @param OnSerie Callback for the Serie icon click action.
 * @param OnActor Callback for the Actor icon click action.
 */
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
        contentColor =  MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.height(dimensionResource(id = R.dimen.bottom_bar_height)),
        actions = {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                IconButton(onClick = OnHome) {
                    Icon(Icons.Outlined.Home, contentDescription = stringResource(id = R.string.Home))
                }
                IconButton(onClick = OnMovie) {
                    Icon(Icons.Outlined.Movie, contentDescription = stringResource(id = R.string.Films))
                }
                IconButton(onClick = OnSerie) {
                    Icon(
                        Icons.Outlined.LocalMovies,
                        contentDescription = stringResource(id = R.string.Series))
                }
                IconButton(onClick = OnActor) {
                    Icon(
                        Icons.Outlined.People,
                        contentDescription = stringResource(id = R.string.Actors))
                }

            }
        }
    )
}

