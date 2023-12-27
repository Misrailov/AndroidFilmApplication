package com.example.filmapplication.screens.home

import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.domain.DomainSerie
/**
 * Data class representing the state of the Home screen.
 *
 * @param scrollActionIdx Index for scroll action.
 * @param scrollToItemIndex Index for the item to scroll to.
 */
data class HomeState(
    val scrollActionIdx: Int = 0,
    val scrollToItemIndex: Int = 0
)

/**
 * Data class representing the state of the Home screen lists.
 *
 * @param films List of favorite films.
 * @param series List of favorite series.
 * @param actors List of favorite actors.
 */
data class HomeListState(
    val films: List<DomainFilm> = listOf(),
    val series: List<DomainSerie> = listOf(),
    val actors: List<DomainActor> = listOf()
)

/**
 * Sealed interface representing the API states for the Home screen.
 */
sealed interface HomeApiState {
    /**
     * Represents a successful API response.
     */
    object Success : HomeApiState

    /**
     * Represents an error in the API response.
     */
    object Error : HomeApiState

    /**
     * Represents the loading state while waiting for the API response.
     */
    object Loading : HomeApiState
}
