package com.example.filmapplication.screens.film

import com.example.filmapplication.domain.DomainFilm
/**
 * Represents the state of the film screen, including scroll information.
 *
 * @property scrollActionIdx The index of the scroll action.
 * @property scrollToItemIndex The index to scroll to.
 */
data class FilmState(
    val scrollActionIdx: Int = 0,
    val scrollToItemIndex: Int = 0
)

/**
 * Represents the state of the film list, including favorite films.
 *
 * @property favouriteFilms A list of favorite films.
 */
data class FilmListState(
    val favouriteFilms: List<DomainFilm> = listOf()
)

/**
 * Represents the possible states of the film-related API calls.
 */
sealed interface FilmApiState {
    /**
     * Represents a successful API call state.
     */
    object Success : FilmApiState

    /**
     * Represents an error in the API call state.
     */
    object Error : FilmApiState

    /**
     * Represents a loading state during an API call.
     */
    object Loading : FilmApiState
}
