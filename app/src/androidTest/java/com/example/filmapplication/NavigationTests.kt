package com.example.filmapplication

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.filmapplication.screens.FilmApp
import com.example.filmapplication.screens.utils.FilmApplicationNavigationType
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTests {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController


    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            FilmApp(FilmApplicationNavigationType.BOTTOM_NAVIGATION)
        }
    }

    @Test
    fun verifyStartDestination() {
        composeTestRule
            .onNodeWithText("Home")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("Your Favourite Movies")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("Your Favourite Series")
            .assertIsDisplayed()


    }

    @Test
    fun navigateToMovies() {
        composeTestRule
            .onNodeWithContentDescription("Films")
            .performClick()
        composeTestRule
            .onNodeWithText("Top Rated Films")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Top Box Office Films (Most Earnings)")
            .assertIsDisplayed()
    }
    @Test
    fun navigateToSeries() {
        composeTestRule
            .onNodeWithContentDescription("Series")
            .performClick()
        composeTestRule
            .onNodeWithText("Most Popular Series")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Top Rated Series")
            .assertIsDisplayed()
    }

    @Test
    fun navigateToActors() {
        composeTestRule
            .onNodeWithContentDescription("Actors")
            .performClick()

        composeTestRule
            .onNodeWithText("Actors")
            .assertIsDisplayed()
    }
    @Test
    fun navigateToActorsAndPressFavouriteButton(){
        composeTestRule
            .onNodeWithContentDescription("Actors")
            .performClick()
        composeTestRule
            .onNodeWithText("Actors")
            .assertIsDisplayed()
        composeTestRule.onAllNodesWithText("Add To Favourites").onFirst().assertIsDisplayed()
        composeTestRule.onAllNodesWithText("Add To Favourites").onFirst().performClick()
        composeTestRule.onAllNodesWithText("Remove From Favourites").onFirst().assertIsDisplayed()

    }



}