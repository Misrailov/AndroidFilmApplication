package com.example.filmapplication.screens.actor.ActorDetails

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.filmapplication.R
import com.example.filmapplication.model.actor.Actor
import com.example.filmapplication.model.film.Film
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen
import com.example.filmapplication.screens.actor.ActorViewModel
import com.example.filmapplication.screens.actor.ActorViewUiState
import com.example.filmapplication.ui.theme.EntertainmentApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActorDetailsScreen(
    actorId: String?,
    navigationController: NavController,actorDetailViewUiState: ActorDetailViewUiState
) {
    Log.e(" actordetailscreen",actorId.toString())
    var actor by remember { mutableStateOf<Actor?>(null)}

    var films: List<Film> by remember { mutableStateOf(listOf()) }

    when(actorDetailViewUiState){
        is ActorDetailViewUiState.Success ->{
            Log.e(" Succes", " Success")
            actor = actorDetailViewUiState.actor;
            films = actorDetailViewUiState.films
        }
        ActorDetailViewUiState.loading ->{
            LoadingScreen(modifier = Modifier.fillMaxSize())
        }
        ActorDetailViewUiState.Error ->{
            ErrorScreen(modifier = Modifier.fillMaxSize())
        }
    }

    // Content for the ActorDetailsScreen
    // Content for the ActorDetailsScreen
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = actor?.primaryName.orEmpty())
                },
                navigationIcon = {
                    IconButton(onClick = { navigationController.popBackStack() }) {
                        Icon(Icons.Outlined.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
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
                    Text(
                        text = "Known For",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 200.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp), // Add spacing between items
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(films) { film ->
                            FilmRow(film = film)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ActorHeader(actor: Actor) {
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

@Composable
fun FilmRow(film: Film) {
    Log.e(" image empty", film.primaryImage.toString())
    Card(
        modifier = Modifier
            .heightIn(min = 200.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // FilmRow contents remain the same
            Image(
                painter = rememberImagePainter(data = film.primaryImage.url),
                contentDescription = "Photo of ${film.titleText.text}",
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp) // Fixed width and height
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.background)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = film.titleText.text,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                maxLines = 2
            )
        }
    }
}