package com.example.filmapplication.screens.serie

import com.example.filmapplication.domain.DomainSerie
/**
 * Represents the state for a scroll action and item index in a TV series list.
 *
 * @property scrollActionIdx The index of the scroll action.
 * @property scrollToItemIndex The index of the item to scroll to.
 */
data class SerieState(
    val scrollActionIdx: Int = 0,
    val scrollToItemIndex: Int = 0
)

/**
 * Represents the state for a list of favorite TV series.
 *
 * @property favouriteSeries The list of favorite TV series.
 */
data class SerieListState(
    val favouriteSeries: List<DomainSerie> = listOf()
)

/**
 * Sealed interface representing the possible states of a TV series API request.
 */
sealed interface SerieApiState {
    /**
     * Represents a successful TV series API request state.
     */
    object Success : SerieApiState

    /**
     * Represents an error state for a TV series API request.
     */
    object Error : SerieApiState

    /**
     * Represents a loading state for a TV series API request.
     */
    object Loading : SerieApiState
}
