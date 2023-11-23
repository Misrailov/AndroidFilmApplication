package com.example.templateapplication.screens.appBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyTopAppBar(currentpage: String) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Black,

            ),
        title = {
            Text(currentpage)
        },
/*
        navigationIcon = navigationIcon
*/
    )
}