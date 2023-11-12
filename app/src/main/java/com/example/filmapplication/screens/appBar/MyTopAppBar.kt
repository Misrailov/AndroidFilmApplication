package com.example.templateapplication.screens.appBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.filmapplication.screens.primaryColor
import com.example.filmapplication.screens.secondaryColor


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyTopAppBar(currentpage: String,  navigationIcon: @Composable () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = primaryColor,
            titleContentColor = secondaryColor,

            ),
        title = {
            Text(currentpage)
        },
        navigationIcon = navigationIcon
    )
}