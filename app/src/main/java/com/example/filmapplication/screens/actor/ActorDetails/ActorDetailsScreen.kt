package com.example.filmapplication.screens.actor.ActorDetails

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.filmapplication.R
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.movie.FilmList


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
    fun addFilmFav(film:DomainFilm){
        actorDetailViewModel.addFilmToFavourites(film)
    }

            when(actorDetailViewModel.actorDetailViewUiState){
        ActorDetailViewUiState.loading ->{
            LoadingScreen(modifier = Modifier.fillMaxSize())
        }
        ActorDetailViewUiState.Error ->{
            ErrorScreen(modifier = Modifier.fillMaxSize())
        }
        is ActorDetailViewUiState.Success ->{

            actor = (actorDetailViewModel.actorDetailViewUiState as ActorDetailViewUiState.Success).actor;
            films = (actorDetailViewModel.actorDetailViewUiState as ActorDetailViewUiState.Success).films
            favouriteFilms = (actorDetailViewModel.actorDetailViewUiState as ActorDetailViewUiState.Success).favFilms
        }
    }

    Scaffold(

        modifier = Modifier
            .padding(PaddingValues(6.dp)),
        content = { padding ->
            if (actor != null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    ActorHeader(actor = actor!!)
                    Spacer(modifier = Modifier.height(16.dp))

                    FilmList(filmList = films, addFilmToFavourites = ::addFilmFav,favouriteFilms=favouriteFilms)

                    }

            }
        }
    )
}

@Composable
fun ActorHeader(actor: DomainActor) {
    Log.e(" actornam", actor.primaryName)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.loading_img),
                contentDescription = "Actor Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = actor.primaryName,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                )
                Text(text = "Born: ${actor.birthYear}")
                if (actor.deathYear != 0) {
                    Text(text = "Died: ${actor.deathYear}")
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Known For",
            style = MaterialTheme.typography.labelSmall,
        )
    }
}
