package com.example.filmapplication.screens.movie

import com.example.filmapplication.domain.DomainFilm

data class FilmState(
    val scrollActionIdx: Int = 0,
    val scrollToItemIndex: Int = 0
)

data class FilmListState(
    val favouriteFilms: List<DomainFilm> = listOf()
)

sealed interface FilmApiState {
    object Success : FilmApiState
    object Error : FilmApiState
    object Loading : FilmApiState
}