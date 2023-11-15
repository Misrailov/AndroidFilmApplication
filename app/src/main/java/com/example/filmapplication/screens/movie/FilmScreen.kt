package com.example.filmapplication.screens.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.filmapplication.model.film.Film
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.actor.Actors
import com.example.filmapplication.screens.primaryColor
@Composable
fun FilmScreen(navigationController: NavController, filmViewUiState: FilmViewUiState) {
    var films: List<Film> by remember { mutableStateOf(listOf()) }
    when (filmViewUiState) {
        is FilmViewUiState.Success -> {
            films = filmViewUiState.films
        }
        FilmViewUiState.loading -> {
            LoadingScreen(modifier = Modifier.fillMaxSize())
        }
        FilmViewUiState.Error -> {
            ErrorScreen(modifier = Modifier.fillMaxSize())
        }
    }

    FilmsList(films = films, navigationController = navigationController)
}

@Composable
fun FilmsList(films: List<Film>, navigationController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 160.dp)
            .padding(start = 16.dp)
    ) {
        if (films.isEmpty()) {
            item {
                Text("No Films found")
            }
        } else {
            films.forEach { film ->
                item {
                    FilmComposable(
                        filmTitle = film.titleText.text,
                        releaseYear = film.releaseYear.year,
                        primaryImage = film.primaryImage.url,
                        navigationController = navigationController
                    )
                }
            }
        }
    }
}

@Composable
fun FilmComposable(
    filmTitle: String,
    releaseYear: Int,
    primaryImage: String,
    navigationController: NavController
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(160.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = rememberImagePainter(data = primaryImage),
                contentDescription = "Photo of $filmTitle",
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.background)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Text(
                    text = filmTitle,
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(top = 16.dp),
                )
                Text(
                    text = releaseYear.toString(),
                    color = primaryColor,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(top = 8.dp),
                )
            }
        }
    }
}
