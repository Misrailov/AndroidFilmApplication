package com.example.taskapp.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import com.example.filmapplication.screens.Destinations

@Composable
fun FilmNavigationRail(selectedDestination: NavDestination?, onTabPressed: (String) -> Unit, modifier: Modifier = Modifier) {
    NavigationRail(modifier = modifier) {
        for (navItem in Destinations.values().copyOfRange(0,4)) {
            NavigationRailItem(
                selected = selectedDestination?.route == navItem.name,
                onClick = { onTabPressed(navItem.name) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.name,
                    )
                },
            )
        }
    }
}
