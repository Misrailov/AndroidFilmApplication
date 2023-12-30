package com.example.filmapplication.screens.appBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

/**
 * A custom TopAppBar used for displaying the current page title.
 *
 * @param currentPage The title or label to be displayed in the app bar.
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyTopAppBar(currentPage: String,navigationIcon: @Composable () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        navigationIcon = navigationIcon,

        title = {
            Text(currentPage)
        },

    )
}