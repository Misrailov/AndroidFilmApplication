package com.example.filmapplication.screens.actor

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.filmapplication.R
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen

/**
 * Composable function to display a list of actors.
 *
 * @param performClick Callback to handle clicking on an actor item.
 * @param actorViewModel View model for managing actor-related data.
 */
@Composable
fun ActorScreen(
    performClick: (id: String) -> Unit, actorViewModel: ActorViewModel = viewModel(
        factory = ActorViewModel.Factory
    )
) {

    val actorListState by actorViewModel.uiListActorState.collectAsState()


    val actorApiState = actorViewModel.actorApiState
    fun addActorToFav(actor: DomainActor) {
        actorViewModel.addActorToFavourites(actor)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.standard_padding)),
    ) {

        Spacer(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.standard_height))
                .padding(
                    start = dimensionResource(id = R.dimen.standard_padding),
                    top = dimensionResource(id = R.dimen.standard_padding)
                ),
        )

        when (actorApiState) {
            is ActorApiState.Loading -> LoadingScreen()
            is ActorApiState.Error -> ErrorScreen()
            is ActorApiState.Success -> ActorList(
                actors = actorListState.actorList,
                favActors = actorListState.favouriteActors,
                addActorToFav = ::addActorToFav,
                performClick = performClick
            )


        }

    }
}

/**
 * Composable function to display a list of actors.
 *
 * @param actors List of actors to display.
 * @param favActors List of favorite actors.
 * @param addActorToFav Callback to add an actor to favorites.
 * @param performClick Callback to handle clicking on an actor item.
 */
@Composable
fun ActorList(
    actors: List<DomainActor>,
    favActors: List<DomainActor>,
    addActorToFav: (item: DomainActor) -> Unit,
    performClick: (item: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.run {
            fillMaxWidth()
                .heightIn(min = dimensionResource(id = R.dimen.min_height))
                .padding(dimensionResource(id = R.dimen.standard_padding))
        },
    ) {
        if (actors.isEmpty()) {
            item {
                Text(stringResource(id = R.string.No_Actors))
            }
        } else {
            actors.forEach { actor ->
                val isFavouriteActor = favActors.contains(actor)
                item {
                    ActorComposable(
                        addActorToFav = addActorToFav,
                        actor = actor,
                        isFavouriteActor = isFavouriteActor ,
                        performClick = performClick
                    )
                }
            }
        }
    }
}

/**
 * Composable function to display an actor item in a card.
 *
 * @param addActorToFav Callback to add an actor to favorites.
 * @param actor The actor to display.
 * @param isFavouriteActor Flag indicating if the actor is a favorite.
 * @param performClick Callback to handle clicking on the actor item.
 */
@Composable
fun ActorComposable(
    addActorToFav: (item: DomainActor) -> Unit,
    actor: DomainActor,
    isFavouriteActor: Boolean,
    performClick: (item: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.small_padding),
                end = dimensionResource(id = R.dimen.standard_padding)
            )
            .fillMaxWidth()
            .heightIn(
                min = dimensionResource(id = R.dimen.min_height),
                max = dimensionResource(id = R.dimen.max_height)
            )
            .padding(bottom = dimensionResource(id = R.dimen.standard_padding))
            .clickable { performClick(actor.nconst) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.standard_elevation),
        ),

        ) {
        Row(
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.medium_padding)),
        ) {

            Column(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.standard_padding)).fillMaxWidth()) {
                Text(
                    text = actor.primaryName,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.standard_padding)),
                )

                Text(
                    text = stringResource(id = R.string.Born) + ": ${actor.birthYear}",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    modifier = Modifier.padding(
                        top = dimensionResource(id = R.dimen.standard_padding),
                        bottom = dimensionResource(id = R.dimen.standard_padding)
                    ),
                )

                Button(
                    onClick = { addActorToFav(actor) },
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.standard_padding), end = dimensionResource(id = R.dimen.standard_padding)),
                ) {
                    Text(
                        text = if (!isFavouriteActor) stringResource(id = R.string.Add_Favourites) else stringResource(
                            id = R.string.Remove_Favourites
                        )
                    )
                }

            }


        }
    }
}
