package com.example.filmapplication.screens.home

import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.domain.DomainSerie

data class HomeState(
    val scrollActionIdx:Int=0,
    val scrollToItemIndex:Int=0
)

data class HomeListState(
    val films:List<DomainFilm> = listOf(),
    val series:List<DomainSerie> = listOf(),
    val actors:List<DomainActor> = listOf()
)
sealed interface HomeApiState{
    object Success:HomeApiState
    object Error:HomeApiState
    object Loading:HomeApiState
}