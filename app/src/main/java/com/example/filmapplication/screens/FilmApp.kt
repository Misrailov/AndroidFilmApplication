package com.example.filmapplication.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.filmapplication.MainActivity
import com.example.filmapplication.screens.actor.ActorViewModel
import com.example.filmapplication.screens.appBar.MyBottomBar
import com.example.templateapplication.screens.appBar.MyTopAppBar
import androidx.navigation.compose.composable
import com.example.filmapplication.screens.actor.ActorDetails.ActorDetailScreen

import com.example.filmapplication.screens.actor.ActorScreen
import com.example.filmapplication.screens.home.HomeScreen
import com.example.filmapplication.screens.movie.FilmScreen
import com.example.filmapplication.screens.serie.SerieScreen


enum class Destinations (val route:String){
    Home("home"),
    Movies("movies"),
    Series("series"),
    Actors("actors"),
    ActorsDetail("actorsDetail");
    fun createRoute(id:String) = "$route/$id"

}


var primaryColor = Color(MainActivity.primaryColor)
var secondaryColor = Color(MainActivity.secondaryColor)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmApp(name: String, modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route

    fun onActorClick(actorId:String){
        navController.navigate(Destinations.ActorsDetail.createRoute(actorId))
    }

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            MyTopAppBar(currentpage =currentDestination.toString() )

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
            startDestination = Destinations.Home.route,
            Modifier.padding(innerPadding),
        ) {
            composable(Destinations.Home.route){
                HomeScreen()

            }
            composable(Destinations.Movies.route){
                //MovieScreen(navController)
                FilmScreen()

            }
            composable(Destinations.Series.route){

                SerieScreen()

            }
            composable(Destinations.Actors.route){
                ActorScreen(::onActorClick)
            }

            composable("${Destinations.ActorsDetail.route}/{id}"){ navBackStackEntry ->


                ActorDetailScreen(actorId =navBackStackEntry.arguments?.getString("id"))



            }

        }

    }
}
