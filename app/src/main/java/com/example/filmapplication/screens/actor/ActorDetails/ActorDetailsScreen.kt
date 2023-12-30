package com.example.filmapplication.screens.actor.ActorDetails

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.filmapplication.R
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.film.FilmList
/**
 * Composable function that displays detailed information about an actor, including their image,
 * name, birth and death years, and a list of films they are known for.
 *
 * @param actorId The ID of the actor to retrieve details for.
 * @param actorDetailViewModel The ViewModel responsible for fetching actor details.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActorDetailScreen(
    actorId: String?,
    actorDetailViewModel: ActorDetailViewModel = viewModel(factory = ActorDetailViewModel.Factory)

) {
    LaunchedEffect(key1 = actorId ){
        actorDetailViewModel.getActorDetails(actorId.toString())
    }

    var actor by remember { mutableStateOf<DomainActor?>(null)}

    var films: List<DomainFilm> by remember { mutableStateOf(listOf()) }
    var favouriteFilms: List<DomainFilm> by remember { mutableStateOf(listOf()) }
    fun addFilmFav(film:DomainFilm,isFavourite:Boolean){
        actorDetailViewModel.addFilmToFavourites(film,isFavourite)
    }

            when(actorDetailViewModel.actorDetailViewUiState){
        ActorDetailViewUiState.Loading ->{
            LoadingScreen(modifier = Modifier.fillMaxSize())
        }
        ActorDetailViewUiState.Error ->{
            ErrorScreen(modifier = Modifier.fillMaxSize())
        }
        is ActorDetailViewUiState.Success ->{

            actor = (actorDetailViewModel.actorDetailViewUiState as ActorDetailViewUiState.Success).actor
            films = (actorDetailViewModel.actorDetailViewUiState as ActorDetailViewUiState.Success).films
        }
    }

    Scaffold(

        modifier = Modifier
            .padding(PaddingValues(dimensionResource(id = R.dimen.drawer_padding_header))),
        content = { padding ->
            if (actor != null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(id = R.dimen.standard_padding)),
                ) {
                    ActorHeader(actor = actor!!)
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.standard_spacing)))

                    FilmList(filmList = films, addFilmToFavourites = ::addFilmFav,favouriteFilms=favouriteFilms, isOnActorPage = true)

                    }

            }
        }
    )
}
/**
 * Composable function to display the header section of an actor's details, including their image,
 * name, birth and death years.
 *
 * @param actor The actor whose details are being displayed.
 */
@Composable
fun ActorHeader(actor: DomainActor) {
    Log.e(" actornam", actor.primaryName)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.standard_padding))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.standard_padding)),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.standard_spacing)))
            Column {
                Text(
                    text = actor.primaryName,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                )

                Text(text = "${stringResource(id = R.string.Died)} ${actor.birthYear}")
                if (actor.deathYear != "0") {
                    Text(text = "Died: ${actor.deathYear}")
                }
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.standard_padding)))
        Text(
            text = "${stringResource(id = R.string.Known_for)} ",
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}
