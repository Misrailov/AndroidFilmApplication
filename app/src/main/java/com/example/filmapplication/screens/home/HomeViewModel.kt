package com.example.filmapplication.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.FilmRepository
import com.example.filmapplication.repository.SerieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class HomeViewModel(
    private val filmRepository: FilmRepository,
    private val actorRepository: ActorRepository,
    private val serieRepository: SerieRepository
) : ViewModel() {
    var homeApiState: HomeApiState by mutableStateOf(HomeApiState.Loading)
        private set
    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()
    lateinit var uiListHomeState: StateFlow<HomeListState>

    init {
        uiListHomeState = MutableStateFlow(HomeListState())

        getFavourites()
    }

    fun getFavourites() {
        try {
            uiListHomeState = filmRepository.getAllFavourites()
                .combine(serieRepository.getAllFavourites()) { films, series ->
                    var actors = listOf<DomainActor>()
                    actorRepository.getAllFavourites().collect() { value -> actors = value }
                    HomeListState(films, series, actors)

                }.stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = HomeListState()
                )
            homeApiState = HomeApiState.Success
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())

        }
    }

}