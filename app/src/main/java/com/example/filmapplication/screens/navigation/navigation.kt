package com.example.filmapplication.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.filmapplication.screens.Destinations
import com.example.filmapplication.screens.actor.ActorDetails.ActorDetailScreen
import com.example.filmapplication.screens.actor.ActorScreen
import com.example.filmapplication.screens.home.HomeScreen
import com.example.filmapplication.screens.movie.FilmScreen
import com.example.filmapplication.screens.serie.SerieScreen
import com.example.filmapplication.screens.utils.FilmApplicationNavigationType

@Composable
fun navComponent(
    navController: NavHostController,
    navigationType: FilmApplicationNavigationType,
    modifier: Modifier = Modifier,
    onActorClick: (String) -> Unit

) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home.route,
        modifier = modifier,
    ) {
        composable(Destinations.Home.route) {
            HomeScreen(performClick = onActorClick)

        }
        composable(Destinations.Movies.route) {
            FilmScreen()

        }
        composable(Destinations.Series.route) {

            SerieScreen()

        }
        composable(Destinations.Actors.route) {
            ActorScreen(performClick = onActorClick)
        }

        composable("${Destinations.ActorsDetail.route}/{id}") { navBackStackEntry ->


            ActorDetailScreen(actorId = navBackStackEntry.arguments?.getString("id"))


        }
    }
}