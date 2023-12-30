package com.example.filmapplication.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.filmapplication.screens.Destinations
import com.example.filmapplication.screens.actor.ActorDetails.ActorDetailScreen
import com.example.filmapplication.screens.actor.ActorScreen
import com.example.filmapplication.screens.home.HomeScreen
import com.example.filmapplication.screens.film.FilmScreen
import com.example.filmapplication.screens.serie.SerieScreen

/**
 * A composable function that defines the navigation component for the Film Application.
 *
 * @param navController The [NavHostController] responsible for handling navigation within the app.
 * @param modifier Modifier for styling and positioning the navigation component.
 * @param onActorClick A callback function to handle actor item clicks.
 */
@Composable
fun NavComponent(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onActorClick: (String) -> Unit,




) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home.route,
        modifier = modifier,
    ) {
        composable(Destinations.Home.route) {
            HomeScreen(goToActor = onActorClick)

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