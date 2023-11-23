package com.example.filmapplication.screens.actor

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.filmapplication.R
import com.example.filmapplication.domain.Role
import com.example.filmapplication.model.actor.Actor
import com.example.filmapplication.screens.ErrorScreen
import com.example.filmapplication.screens.LoadingScreen


@Composable
fun ActorScreen (navigationController:NavController, actorViewUiState: ActorViewUiState){
    var actors: List<Actor> by remember { mutableStateOf(listOf()) }
    when(actorViewUiState){
        is ActorViewUiState.Success ->{
            actors = actorViewUiState.actors;
        }
        ActorViewUiState.loading->{
            LoadingScreen(modifier = Modifier.fillMaxSize())
        }
        ActorViewUiState.Error ->{
            ErrorScreen(modifier = Modifier.fillMaxSize())
        }
    }

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
        Actors(actors = actors, navigationController = navigationController)
    }
}

@Composable
fun Actors(actors:List<Actor>, navigationController: NavController){
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
                item {
                    ActorComposable(
                        actorId = actor.nconst,
                        actorName = actor.primaryName,

                        playedIn=actor.knownForTitles.split(","),
                        /*images= actor.,*/
                        birthDate= actor.birthYear,
                        role = if (actor.primaryProfession == "actor" || actor.primaryProfession == "actress") Role.ACTOR else Role.OTHER_ROLE,
                        navigationController= navigationController
                    )
                }
            }
        }
    }
}@Composable
fun ActorComposable(
    actorId: String,
    actorName: String,
    playedIn: List<String>,
    birthDate: Int,
    role: Role,
    navigationController: NavController
) {
    Card(
        modifier = Modifier
            .padding(start = 4.dp, end = 12.dp)
            .widthIn(max = 350.dp, min = 350.dp)
            .heightIn(min = 160.dp, max = 160.dp)
            .clickable { /* Handle click here */ },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp,
        ),
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp),
        ) {
            Column {
                Text(
                    text = actorName,
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 16.dp),
                )
            }

            // Other details or image can be added here

            // Handle click by navigating to the actor details screen
            Image(
                painter = rememberImagePainter(data = R.drawable.loading_img),
                contentDescription = "picture of $actorName",
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
                    .clickable {
                        // Navigate to actor details screen
                        // You can pass necessary details to the destination screen
                       navigationController.navigate("actorDetailsScreen/$actorId")

                    },
            )
        }
    }
}
