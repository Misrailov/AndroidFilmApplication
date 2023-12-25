package com.example.filmapplication.screens.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberImagePainter
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmScreen(filmViewModel: FilmViewModel = viewModel(factory = FilmViewModel.Factory)) {

    var films = filmViewModel.apiFilmPager.collectAsLazyPagingItems();
    var worstFilms = filmViewModel.apiFilmPagerWorstMovies.collectAsLazyPagingItems();
    var bestFilms = filmViewModel.apiFilmPagerTopRated.collectAsLazyPagingItems();
    val filmListState by filmViewModel.uiListFilmState.collectAsState()
    val filmApiState = filmViewModel.filmApiState
    var favouriteFilms = listOf<DomainFilm>()
    fun addFilmFav(film:DomainFilm){
        filmViewModel.addFilmToFavourites(film)
    }

    when (filmApiState) {
        is FilmApiState.Error -> ErrorScreen()
        is FilmApiState.Loading -> LoadingScreen()
        is FilmApiState.Success -> {
            favouriteFilms = filmListState.favouriteFilms
            Scaffold { padding ->
                Spacer(modifier = Modifier.padding(padding))
                LazyRow {
                    item {
                        Column {
                            Text(text = "Top Box Office films (most earnings)")

                            FilmList(filmsPaged = films, addFilmToFavourites = ::addFilmFav, favouriteFilms =  favouriteFilms)
                        }
                    }
                    item {
                        Column {
                            Text(text = "Top rated films")
                            FilmList(filmsPaged = bestFilms, addFilmToFavourites = ::addFilmFav, favouriteFilms = favouriteFilms)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun FilmList(
    filmList:List<DomainFilm>? = listOf<DomainFilm>(),
    filmsPaged: LazyPagingItems<DomainFilm>? = null,
    addFilmToFavourites:(film:DomainFilm)->Unit,
    favouriteFilms: List<DomainFilm>
) {



    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 160.dp)
            .padding(start = 16.dp)
    ) {
        if(filmsPaged !=null){
        itemsIndexed(filmsPaged) { _, film ->
            val isFavourite =
                favouriteFilms.filter { x -> x.id == film!!.id && x.isFavourite }.isNotEmpty()

            film?.let {
                FilmComposable(
                    film,
                    addFilmToFavourites,
                    isFavourite
                )

            }
        }
    }else{
        filmList?.forEach { film -> item {
            val isFavourite =
                favouriteFilms.filter { x -> x.id == film.id && x.isFavourite }.isNotEmpty()

            film.let {
                FilmComposable(
                    film,
                    addFilmToFavourites,
                    isFavourite
                )

            }
        } }
        }
    }
}

@Composable
fun FilmComposable(
    film: DomainFilm,
    addFilmToFavourites:(film:DomainFilm)->Unit,
    isFavourite: Boolean
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
                painter = rememberImagePainter(data = film.primaryImage),
                contentDescription = "Photo of ${film.titleText}",
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
                    text = film.titleText,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                Text(
                    text = "Released in ${film.releaseYear}",
                    color = primaryColor,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
                Button(onClick = { addFilmToFavourites(film) }) {
                    Text(text = if (!isFavourite) "Add to Favourites" else "Remove From Favourites")
                }
            }
        }
    }
}