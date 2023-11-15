package com.example.filmapplication.screens.serie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
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
import com.example.filmapplication.model.serie.Serie
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.primaryColor


@Composable
fun SerieScreen(navigationController: NavController, serieViewUiState: SerieViewUiState) {
    var series: List<Serie> by remember { mutableStateOf(listOf()) }
    when (serieViewUiState) {
        is SerieViewUiState.Success -> {
            series = serieViewUiState.series
        }
        SerieViewUiState.loading -> {
            LoadingScreen(modifier = Modifier.fillMaxSize())
        }
        SerieViewUiState.Error -> {
            ErrorScreen(modifier = Modifier.fillMaxSize())
        }
    }

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Spacer(
            modifier = Modifier
                .height(16.dp)
                .padding(start = 16.dp, top = 16.dp),
        )
        Series(series = series, navigationController = navigationController)
    }
}

@Composable
fun Series(series: List<Serie>, navigationController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 160.dp)
            .padding(start = 16.dp)
    ) {
        if (series.isEmpty()) {
            item {
                Text("No Series found")
            }
        } else {
            series.forEach { serie ->
                item {
                    SerieComposable(
                        filmTitle = serie.titleText.text,
                        releaseYear = serie.releaseDate.year,
                        primaryImage = serie.primaryImage.url,
                        navigationController = navigationController
                    )
                }
            }
        }
    }
}

@Composable
fun SerieComposable(
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
