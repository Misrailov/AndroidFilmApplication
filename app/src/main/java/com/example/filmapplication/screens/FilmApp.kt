package com.example.filmapplication.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.filmapplication.screens.appBar.MyBottomBar
import com.example.filmapplication.R
import com.example.filmapplication.screens.appBar.MyTopAppBar
import com.example.filmapplication.screens.navigation.FilmNavigationRail
import com.example.filmapplication.screens.navigation.NavigationDrawerContent

import com.example.filmapplication.screens.navigation.NavComponent
import com.example.filmapplication.screens.utils.FilmApplicationNavigationType

/**
 * Enum class representing various destinations in the film application.
 *
 * @property route The route associated with the destination.
 * @property icon The icon associated with the destination.
 */
enum class Destinations (val route:String,val icon: ImageVector){
    Home("home",icon = Icons.Filled.Home),
    Movies("movies",icon = Icons.Filled.Movie),
    Series("series",icon = Icons.Filled.LocalMovies),
    Actors("actors",icon = Icons.Filled.People),
    ActorsDetail("actors detail",icon = Icons.Filled.Person);


    /**
     * Creates a route with the specified ID appended to the destination's route.
     *
     * @param id The ID to be appended to the route.
     * @return The complete route.
     */
    fun createRoute(id:String) = "$route/$id"

}

/**
 * Composable function for the main film application.
 *
 * @param navigationType The type of navigation to use.
 * @param navController The navigation controller.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmApp(navigationType: FilmApplicationNavigationType,navController:NavHostController = rememberNavController()) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route
    val currentEnumDestination: Destinations? = currentDestination?.let { route -> enumValues<Destinations>().find { it.route == route } }
    val currentpage = currentEnumDestination?.name ?: "Actor Details"
    val goToHome = { navController.navigate(Destinations.Home.route) }
    val goToMovies = { navController.navigate(Destinations.Movies.route) }
    val goToSeries = { navController.navigate(Destinations.Series.route) }
    val goToActors = { navController.navigate(Destinations.Actors.route) }
    /**
     * Handles navigation to the actor detail screen.
     *
     * @param actorId The ID of the actor to display details for.
     */
    fun onActorClick(actorId:String){
        navController.navigate(Destinations.ActorsDetail.createRoute(actorId))
    }

    if (navigationType == FilmApplicationNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(drawerContent = {
            PermanentDrawerSheet(Modifier.width(dimensionResource(R.dimen.drawer_width))) {
                NavigationDrawerContent(
                    selectedDestination = navController.currentDestination,
                    onTabPressed = { node: String -> navController.navigate(node) },
                    modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.inverseOnSurface)
                        .padding(dimensionResource(R.dimen.drawer_padding_content)),
                )
            }
        }) {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.background,
                topBar = {
                    MyTopAppBar(
                        currentPage = currentpage,
                    ){
                        val isStartDestination = currentDestination == Destinations.Home.route
                        if (!isStartDestination) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Localized description", tint = MaterialTheme.colorScheme.onPrimary)
                        }
                    }
                    }
                },

            ) { innerPadding ->

                NavComponent(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding),
                    onActorClick = ::onActorClick

                )
            }
        }
    } else if (navigationType == FilmApplicationNavigationType.BOTTOM_NAVIGATION) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                MyTopAppBar(
                    currentPage = currentpage,
                ){
                val isStartDestination = currentDestination == Destinations.Home.route
                if (!isStartDestination) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Localized description", tint = MaterialTheme.colorScheme.onBackground)
                    }
                }}

            },
            bottomBar = {

                MyBottomBar(goToHome, goToMovies, goToSeries, goToActors)

            },

        ) { innerPadding ->
            NavComponent(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                onActorClick = ::onActorClick



            )
        }
    } else {
        Row {
            AnimatedVisibility(visible = navigationType == FilmApplicationNavigationType.NAVIGATION_RAIL) {
                val navigationRailContentDescription = stringResource(R.string.navigation_rail)
                FilmNavigationRail(
                    selectedDestination = navController.currentDestination,
                    onTabPressed = { node: String -> navController.navigate(node) },
                )
            }
            Scaffold(
                containerColor = MaterialTheme.colorScheme.background,
                topBar = {
                    MyTopAppBar(
                        currentPage = currentpage,
                    ){

                        val isStartDestination = currentDestination == Destinations.Home.route
                        if (!isStartDestination) {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(Icons.Filled.ArrowBack, contentDescription = "Localized description", tint = MaterialTheme.colorScheme.onPrimary)
                            }
                        }
                    }
                },

            ) { innerPadding ->

                NavComponent(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding),
                    onActorClick = ::onActorClick


                )
            }
        }
    }
}
