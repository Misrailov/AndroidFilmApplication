package com.example.filmapplication.screens.movie

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberImagePainter
import com.example.filmapplication.model.film.Film
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmScreen(navigationController: NavController, filmViewModel:FilmViewModel = viewModel(factory =FilmViewModel.Factory) ) {

    var films = filmViewModel.filmPager.collectAsLazyPagingItems();
    var worstFilms = filmViewModel.filmPagerWorstMovies.collectAsLazyPagingItems();
    var bestFilms = filmViewModel.filmPagerTopRated.collectAsLazyPagingItems();

   when(films.loadState.refresh){
       is LoadState.Loading -> LoadingScreen()
       is LoadState.Error-> {
           Log.e("error", "errorScreenMovies")
           ErrorScreen()}
       else ->{

           Scaffold { padding->
               Spacer(modifier = Modifier.padding(padding))
               LazyRow {
                   item {
                       Column{
                           Text(text = "Top Box Office films (most earnings)")

                           filmList(films = films)
                       }
                   }
                   item {
                       Column{
                           Text(text = "Top rated films")
                           filmList(films = bestFilms)
                       }
                   }
                   item {
                       Column {
                           Text(text ="Worst Films Ever" )

                           filmList(films = worstFilms)
                       }

                   }
               }
           }
       }
   }
}



@Composable
fun filmList(films:LazyPagingItems<Film>) {


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 160.dp)
            .padding(start = 16.dp)
    ) {
        itemsIndexed(films) { index, film ->

        film?.let {
                Log.e("filmInfo", film.titleText.text)
                FilmComposable(
                    filmTitle = film.titleText.text,
                    releaseYear = film.releaseYear.year,
                    primaryImage = film.primaryImage.url,
                )

            }
        }
    }
}

@Composable
fun FilmComposable(
    filmTitle: String,
    releaseYear: Int,
    primaryImage: String,
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .defaultMinSize(300.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(data = primaryImage),
                contentDescription = "Photo of $filmTitle",
                modifier = Modifier
                    .width(300.dp)
                    .height(400.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = filmTitle,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                Text(
                    text = "Released in $releaseYear",
                    color = primaryColor,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
            }
        }
    }
}