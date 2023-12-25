package com.example.filmapplication.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.domain.DomainSerie
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.actor.ActorList
import com.example.filmapplication.screens.movie.FilmList
import com.example.filmapplication.screens.serie.SerieList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory),
    performClick: (id: String) -> Unit
) {

    val homeListState by homeViewModel.uiListHomeState.collectAsState()
    val homeApiState = homeViewModel.homeApiState
    fun addFilmFav(film: DomainFilm) {
        homeViewModel.addFilmToFavourites(film)
    }

    fun addSerieFav(serie: DomainSerie) {
        homeViewModel.addSerieToFavourites(serie)
    }

    fun addActorToFav(actor: DomainActor) {
        homeViewModel.addActorToFavourites(actor)
    }


    when (homeApiState) {
        is HomeApiState.Error -> ErrorScreen()
        is HomeApiState.Loading -> LoadingScreen()
        is HomeApiState.Success -> {
            Log.e("Succes",homeListState.series.count().toString())
            Scaffold { padding ->
                Spacer(modifier = Modifier.padding(padding))
                LazyRow {
                    item {
                        Column {
                            Text(text = "Your Favourite Actors")
                            ActorList(
                                actors = homeListState.actors,
                                favActors = homeListState.actors,
                                addActorToFav = ::addActorToFav,
                                performClick = performClick
                            )
                        }
                    }
                    item {
                        Column {
                            Text(text = "Your Favourite Films")

                            FilmList(
                                filmList = homeListState.films,
                                addFilmToFavourites = ::addFilmFav,
                                favouriteFilms = homeListState.films
                            )
                        }
                    }
                    item {
                        Column {
                            Text(text = "Your Favourite Series")
                            SerieList(
                                serieList = homeListState.series,
                                addSerieToFav = ::addSerieFav,
                                favouriteSeries = homeListState.series
                            )
                        }
                    }

                }
            }

        }
    }
}

