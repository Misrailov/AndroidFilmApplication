package com.example.filmapplication.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.filmapplication.MainActivity
import com.example.filmapplication.screens.actor.ActorViewModel
import com.example.filmapplication.screens.appBar.MyBottomBar
import com.example.templateapplication.screens.appBar.MyTopAppBar
import androidx.navigation.compose.composable
import com.example.filmapplication.screens.actor.ActorDetails.ActorDetailViewModel
import com.example.filmapplication.screens.actor.ActorDetails.ActorDetailsScreen
import com.example.filmapplication.screens.actor.ActorScreen
import com.example.filmapplication.screens.movie.FilmScreen
import com.example.filmapplication.screens.movie.FilmViewModel
import com.example.filmapplication.screens.serie.SerieScreen
import com.example.filmapplication.screens.serie.SerieViewModel
import com.example.filmapplication.ui.theme.EntertainmentApplicationTheme
import kotlinx.coroutines.newFixedThreadPoolContext


enum class Destinations {
    Home,
    Movies,
    Series,
    Actors,
    ActorsDetail
}

var primaryColor = Color(MainActivity.primaryColor)
var secondaryColor = Color(MainActivity.secondaryColor)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmApp(name: String, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route
    val actorViewModel :ActorViewModel = viewModel(factory = ActorViewModel.Factory)
    val filmViewModel: FilmViewModel = viewModel(factory = FilmViewModel.Factory)
    val serieViewModel:SerieViewModel = viewModel(factory = SerieViewModel.Factory)
    val actorDetailViewModel:ActorDetailViewModel = viewModel(factory = ActorDetailViewModel.Factory)
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            MyTopAppBar(currentpage =currentDestination.toString() ) {
                val isStartDestionation = currentDestination == Destinations.Home.name
                if(!isStartDestionation){
                    IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, contentDescription = "Localized description", tint = Color(0xFFFEFEFE)) }
                }

            }
        },
        bottomBar = {
            MyBottomBar(
                OnHome = { navController.popBackStack(Destinations.Home.name, inclusive = false) },
                OnMovie = { navController.navigate(Destinations.Movies.name) },
                OnSerie = { navController.navigate(Destinations.Series.name) },
                OnActor = {navController.navigate(Destinations.Actors.name)},)

        },



    ){innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destinations.Home.name,
            Modifier.padding(innerPadding),
        ) {
            composable(Destinations.Home.name){
                //HomeScreen(navController)
                ActorScreen(navController, actorViewModel.actorViewUiState)

            }
            composable(Destinations.Movies.name){
                //MovieScreen(navController)
                FilmScreen(navController)

            }
            composable(Destinations.Series.name){

               // SerieScreen(navController)
                System.out.println(serieViewModel.serieViewUiState.toString())
                SerieScreen(navController, serieViewModel.serieViewUiState)

            }
            composable(Destinations.Actors.name){
                ActorScreen(navController, actorViewModel.actorViewUiState)
            }

            composable("actorDetailsScreen/{actorId}"){ navBackStackEntry ->


                val actorId = navBackStackEntry.arguments?.getString("actorId")
                actorDetailViewModel.SetId(actorId.toString())
                ActorDetailsScreen(
                    actorId = actorId,
                    navigationController =navController ,
                    actorDetailViewUiState =actorDetailViewModel.actorDetailViewUiState
                )


            }

        }

    }
}
