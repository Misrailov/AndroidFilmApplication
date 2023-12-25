package com.example.filmapplication.screens.actor

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.filmapplication.R
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.Role
import com.example.filmapplication.model.actor.ApiActor
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen


@Composable
fun ActorScreen (performClick: (id:String)->Unit, actorViewModel: ActorViewModel = viewModel(
    factory=ActorViewModel.Factory
)){

    val actorState by actorViewModel.uiState.collectAsState()
    val actorListState by actorViewModel.uiListActorState.collectAsState()


    val actorApiState = actorViewModel.actorApiState


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

        when(actorApiState){
            is ActorApiState.Loading -> LoadingScreen()
            is ActorApiState.Error -> ErrorScreen()
            //is  ActorApiState.Success ->  Actors(actors = actorListState.actorList, performClick = { s -> navigationController.navigate(s)})
            is  ActorApiState.Success ->  Actors(actors = actorListState.actorList,favActors = actorListState.favouriteActors,actorViewModel, performClick = performClick)


        }

    }
}

@Composable
fun Actors(actors:List<DomainActor>,favActors:List<DomainActor>,actorViewModel: ActorViewModel,performClick: (item: String) -> Unit){
    LazyColumn(        modifier = Modifier.run {
        fillMaxWidth()
            .heightIn(min = 160.dp)
            .padding(start = 16.dp)
    },
        ){
        if(actors.isEmpty()){
            item{
                Text("No Actors found")
            }
        }else {
            actors.forEach { actor ->
                var isFavouriteActor = favActors.contains(actor)
                item {
                    ActorComposable(
                        actorViewModel = actorViewModel,
                        actor= actor,
                        isFavouriteActor=isFavouriteActor,
                        performClick = performClick
                    )
                }
            }
        }
    }
}@Composable
fun ActorComposable(
    actorViewModel: ActorViewModel,
    actor:DomainActor,
    isFavouriteActor:Boolean,
    performClick: (item:String)->Unit
) {
    Card(
        modifier = Modifier
            .padding(start = 4.dp, end = 12.dp)
            .widthIn(max = 350.dp, min = 350.dp)
            .heightIn(min = 160.dp, max = 160.dp)
            .clickable { performClick(actor.nconst) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp,
        ),

    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp),
        ) {
            Column {
                Text(
                    text = actor.primaryName,
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 16.dp),
                )

                Text(
                    text = "Born: " + actor.birthYear,
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 16.dp),
                )
                Log.e("actor",actor.isFavourite.toString())

                Button(onClick = { actorViewModel.addActorToFavourites(actor) }) {
                    Text(text = if (isFavouriteActor) "Add to Favourites" else "Remove From Favourites")
                }

            }



        }
    }
}
