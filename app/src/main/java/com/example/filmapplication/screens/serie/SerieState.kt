package com.example.filmapplication.screens.serie

import com.example.filmapplication.domain.DomainSerie

data class SerieState(
    val scrollActionIdx: Int = 0,
    val scrollToItemIndex: Int = 0
)

data class SerieListState(
    val favouriteSeries: List<DomainSerie> = listOf()
)

sealed interface SerieApiState {
    object Success : SerieApiState
    object Error : SerieApiState
    object Loading : SerieApiState
}