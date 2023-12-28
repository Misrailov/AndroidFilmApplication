package com.example.filmapplication.screens.actor

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.filmapplication.FilmApplication
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.DomainSerie
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * ViewModel class for managing actor-related data and UI states.
 *
 * @param actorRepository The repository for actor-related data.
 * @param filmRepository The repository for film-related data.
 */
class ActorViewModel(
    private val actorRepository: ActorRepository,
    private val filmRepository: FilmRepository
) : ViewModel() {
    /**
     * The current state of actor API call, represented by [ActorApiState].
     */
    var actorApiState: ActorApiState by mutableStateOf(ActorApiState.Loading)
        private set

    /**
     * A [StateFlow] representing the UI state of the actor screen.
     */
    private val _uiState = MutableStateFlow(ActorState())
    val uiState: StateFlow<ActorState> = _uiState.asStateFlow()

    /**
     * A [StateFlow] representing the list of actors and their favorite status.
     */
    lateinit var uiListActorState: StateFlow<ActorListState>

    init {
        getRepoActors()
    }

    /**
     * Toggles the favorite status of an actor and inserts the updated data into the repository.
     *
     * @param actor The [DomainActor] object to be added or removed from favorites.
     */
    fun addActorToFavourites(actor: DomainActor) {
        actor.isFavourite = !actor.isFavourite
        viewModelScope.launch {
            actorRepository.insert(actor)
        }
    }

    /**
     * Fetches actor data from the repository, updates the UI states, and handles API call results.
     */
    fun getRepoActors() {
        viewModelScope.launch {
        try {
            viewModelScope.launch { actorRepository.refresh() }
            uiListActorState = actorRepository.getAllItems().combine(actorRepository.getAllFavourites()) { actors, favouriteActors ->
                ActorListState(actors, favouriteActors)
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = ActorListState()
            )
            actorApiState = ActorApiState.Success
        } catch (e: IOException) {
            actorApiState = ActorApiState.Error
        }}
    }

    companion object {
        /**
         * Factory for creating instances of [ActorViewModel].
         */
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FilmApplication)
                val actorRepository = application.container.actorRepository
                val filmRepository = application.container.filmRepository

                ActorViewModel(actorRepository, filmRepository)
            }
        }
    }
}
