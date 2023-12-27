package com.example.filmapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.filmapplication.R
/**
 * Composable function for displaying a loading screen with a loading image.
 *
 * @param modifier The modifier for the loading screen.
 */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(dimensionResource(id = R.dimen.default_Screen_size)),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading"
    )
}