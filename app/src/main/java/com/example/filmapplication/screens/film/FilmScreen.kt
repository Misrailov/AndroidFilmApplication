package com.example.filmapplication.screens.film

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberImagePainter
import com.example.filmapplication.R
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen

/**
 * Composable function for displaying a list of films, including top-rated films, worst films,
 * and other film-related content.
 *
 * @param filmViewModel ViewModel responsible for handling film-related data and actions.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmScreen(
    filmViewModel: FilmViewModel = viewModel(factory = FilmViewModel.Factory)
) {

    var films = filmViewModel.apiFilmPager.collectAsLazyPagingItems();
    var bestFilms = filmViewModel.apiFilmPagerTopRated.collectAsLazyPagingItems();
    val filmListState by filmViewModel.uiListFilmState.collectAsState()
    val filmApiState = filmViewModel.filmApiState
    var favouriteFilms = listOf<DomainFilm>()
    fun addFilmFav(film: DomainFilm) {
        filmViewModel.addFilmToFavourites(film)
    }




    when (filmApiState) {
        is FilmApiState.Error -> ErrorScreen()
        is FilmApiState.Loading -> LoadingScreen()
        is FilmApiState.Success -> {
            favouriteFilms = filmListState.favouriteFilms
            Scaffold(
            ) { padding ->


                Spacer(modifier = Modifier.padding(padding))
                LazyRow {
                    item {
                        Column {
                            Text(text = stringResource(R.string.TopBox_Movies), Modifier.padding(start = dimensionResource(id = R.dimen.standard_padding), end = dimensionResource(id = R.dimen.standard_padding)))

                            FilmList(
                                filmsPaged = films,
                                addFilmToFavourites = ::addFilmFav,
                                favouriteFilms = favouriteFilms
                            )
                        }
                    }
                    item {
                        Column {
                            Text(text = stringResource(R.string.Top_Rated_Films), Modifier.padding(start = dimensionResource(id = R.dimen.standard_padding), end = dimensionResource(id = R.dimen.standard_padding)))
                            FilmList(
                                filmsPaged = bestFilms,
                                addFilmToFavourites = ::addFilmFav,
                                favouriteFilms = favouriteFilms

                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Composable function for displaying a list of films.
 *
 * @param filmList A list of films to display.
 * @param filmsPaged LazyPagingItems containing films to display (optional, if using paging).
 * @param addFilmToFavourites Function to add a film to favorites.
 * @param favouriteFilms List of favorite films.
 */
@Composable
fun FilmList(
    filmList: List<DomainFilm>? = listOf<DomainFilm>(),
    filmsPaged: LazyPagingItems<DomainFilm>? = null,
    addFilmToFavourites: (film: DomainFilm) -> Unit,
    favouriteFilms: List<DomainFilm>,isOnActorPage: Boolean = false

) {


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = dimensionResource(id = R.dimen.min_height))
            .padding(start = dimensionResource(id = R.dimen.standard_padding))
    ) {
        if(filmList.isNullOrEmpty() && filmsPaged?.itemCount==0){
            item {
                Text(stringResource(id = R.string.No_Films))
            }
        }
        if (filmsPaged != null) {
            itemsIndexed(filmsPaged) { _, film ->
                val isFavourite =
                    favouriteFilms.filter { x -> x.id == film!!.id && x.isFavourite }.isNotEmpty()

                film?.let {
                    FilmComposable(
                        film,
                        addFilmToFavourites,
                        isFavourite,
                        isOnActorPage = isOnActorPage
                    )

                }
            }
        } else {
            filmList?.forEach { film ->
                item {
                    val isFavourite =
                        favouriteFilms.filter { x -> x.id == film.id && x.isFavourite }.isNotEmpty()

                    film.let {
                        FilmComposable(
                            film,
                            addFilmToFavourites,
                            isFavourite
                            ,isOnActorPage = isOnActorPage
                        )

                    }
                }
            }
        }
    }
}

/**
 * Composable function for displaying an individual film item.
 *
 * @param film The film to display.
 * @param addFilmToFavourites Function to add a film to favorites.
 * @param isFavourite Boolean indicating whether the film is in the user's favorites.
 */
@Composable
fun FilmComposable(
    film: DomainFilm,
    addFilmToFavourites: (film: DomainFilm) -> Unit,
    isFavourite: Boolean,
    isOnActorPage:Boolean = false
) {
    var modifierCard = if(!isOnActorPage) Modifier
        .padding(
            horizontal = dimensionResource(id = R.dimen.medium_padding),
            vertical = dimensionResource(id = R.dimen.medium_padding)
        )
        .fillMaxWidth()
        .defaultMinSize(dimensionResource(id = R.dimen.standard_min_size)) else
        Modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.medium_padding),
                vertical = dimensionResource(id = R.dimen.medium_padding)
            )
            .width(dimensionResource(id = R.dimen.standard_width))

            .defaultMinSize(dimensionResource(id = R.dimen.standard_min_size))
    Card(
        modifier = modifierCard,

        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.standard_elevation)
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(data = film.primaryImage),
                contentDescription = stringResource(id = R.string.Photo_Of) + "${film.titleText}",
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.standard_width))
                    .height(dimensionResource(id = R.dimen.img_card_size))
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.primary)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.medium_padding))
            ) {
                Text(
                    text = film.titleText,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.medium_padding))
                )
                Text(
                    text = stringResource(id = R.string.Released_in) + " ${film.releaseYear}",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.small_padding))
                )
                if(!isOnActorPage){
                Button(onClick = { addFilmToFavourites(film) }) {
                    Text(
                        text = if (!isFavourite) stringResource(R.string.Add_Favourites) else stringResource(
                            R.string.Remove_Favourites
                        )
                    )
                }}
            }
        }
    }
}