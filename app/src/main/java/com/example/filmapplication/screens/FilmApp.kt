package com.example.filmapplication.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.filmapplication.MainActivity
import com.example.filmapplication.screens.appBar.MyBottomBar
import com.example.templateapplication.screens.appBar.MyTopAppBar
import com.example.filmapplication.R

import com.example.filmapplication.screens.navigation.navComponent
import com.example.filmapplication.screens.utils.FilmApplicationNavigationType
import com.example.taskapp.ui.components.FilmNavigationRail
import com.example.taskapp.ui.components.NavigationDrawerContent


enum class Destinations (val route:String,val icon: ImageVector){
    Home("home",icon = Icons.Filled.Home),
    Movies("movies",icon = Icons.Filled.Movie),
    Series("series",icon = Icons.Filled.LocalMovies),
    Actors("actors",icon = Icons.Filled.People),
    ActorsDetail("actors detail",icon = Icons.Filled.Person);
    fun createRoute(id:String) = "$route/$id"

}


var primaryColor = Color(MainActivity.primaryColor)
var secondaryColor = Color(MainActivity.secondaryColor)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmApp(navigationType: FilmApplicationNavigationType,navController:NavHostController = rememberNavController()) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route
    val currentEnumDestination: Destinations? = currentDestination?.let { route -> enumValues<Destinations>().find { it.route == route } }
    val currentpage = currentEnumDestination?.name ?: Destinations.Home.name
    val goToHome = { navController.navigate(Destinations.Home.route) }
    val goToMovies = { navController.navigate(Destinations.Movies.route) }
    val goToSeries = { navController.navigate(Destinations.Series.route) }
    val goToActors = { navController.navigate(Destinations.Actors.route) }
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
                        currentpage = currentpage,
                    )
                },

            ) { innerPadding ->

                navComponent(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding),
                    navigationType = navigationType,
                    onActorClick = ::onActorClick

                )
            }
        }
    } else if (navigationType == FilmApplicationNavigationType.BOTTOM_NAVIGATION) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                MyTopAppBar(
                    currentpage = currentpage,
                )
            },
            bottomBar = {

                MyBottomBar(goToHome, goToMovies, goToSeries, goToActors)

            },

        ) { innerPadding ->
            navComponent(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                navigationType = navigationType,
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
                        currentpage = currentpage,
                    )
                },

            ) { innerPadding ->

                navComponent(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding),
                    navigationType = navigationType,
                    onActorClick = ::onActorClick

                )
            }
        }
    }
}
