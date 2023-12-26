package com.example.filmapplication.screens.movie

import android.graphics.drawable.Icon
import android.widget.Toast
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberImagePainter
import com.example.filmapplication.R
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.network.NetworkConnectionInterceptor
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.primaryColor
import kotlinx.coroutines.launch

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
    val networkCheck = NetworkConnectionInterceptor(LocalContext.current)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()


    when (filmApiState) {
        is FilmApiState.Error -> ErrorScreen()
        is FilmApiState.Loading -> LoadingScreen()
        is FilmApiState.Success -> {
            favouriteFilms = filmListState.favouriteFilms
            Scaffold( snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },) { padding ->

                if(!networkCheck.isConnected(LocalContext.current)){
                    scope.launch {
                        snackbarHostState.showSnackbar( R.string.No_Internet.toString())
                    }
                }
                Spacer(modifier = Modifier.padding(padding))
                LazyRow {
                    item {
                        Column {
                            Text(text = stringResource(R.string.TopBox_Movies))

                            FilmList(filmsPaged = films, addFilmToFavourites = ::addFilmFav, favouriteFilms =  favouriteFilms)
                        }
                    }
                    item {
                        Column {
                            Text(text = stringResource(R.string.Top_Rated_Films))
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
            .heightIn(min = dimensionResource(id = R.dimen.min_height))
            .padding(start = dimensionResource(id = R.dimen.standard_padding))
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
            .padding(
                horizontal = dimensionResource(id = R.dimen.medium_padding),
                vertical = dimensionResource(id = R.dimen.medium_padding)
            )
            .fillMaxWidth()
            .defaultMinSize(dimensionResource(id = R.dimen.standard_min_size)),
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
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.medium_padding))
                )
                Text(
                    text = stringResource(id = R.string.Released_in) + " ${film.releaseYear}",
                    color = primaryColor,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.small_padding))
                )
                Button(onClick = { addFilmToFavourites(film) }) {
                    Text(text = if (!isFavourite)  stringResource(R.string.Add_Favourites) else  stringResource(R.string.Remove_Favourites))
                }
            }
        }
    }
}