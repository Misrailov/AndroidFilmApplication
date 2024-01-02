package com.example.filmapplication.screens.actor.ActorDetails

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.filmapplication.FilmApplication
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.launch
/**
 * Represents the possible UI states for the Actor Detail screen.
 */
sealed interface ActorDetailViewUiState {
    /**
     * Loading state: Indicates that data is being fetched.
     */
    object Loading : ActorDetailViewUiState

    /**
     * Success state: Indicates that data has been successfully loaded.
     *
     * @property films The list of films associated with the actor.
     * @property actor The detailed information about the actor.
     */
    data class Success(
        val films: List<DomainFilm>,
        val actor: DomainActor,


        ) : ActorDetailViewUiState

    /**
     * Error state: Indicates that an error occurred while fetching data.
     */
    object Error : ActorDetailViewUiState
}

/**
 * ViewModel class for the Actor Detail screen.
 *
 * @param actorRepository The repository for actor-related data.
 * @param filmRepository The repository for film-related data.
 */
class ActorDetailViewModel(
    private val actorRepository: ActorRepository,
    private val filmRepository: FilmRepository
) : ViewModel() {
    /**
     * Current UI state for the Actor Detail screen.
     */
    var actorDetailViewUiState: ActorDetailViewUiState by mutableStateOf(ActorDetailViewUiState.Loading)
        private set

    /**
     * Fetches actor details and associated films.
     *
     * @param id The ID of the actor to retrieve details for.
     */
    fun getActorDetails(id: String) {
        viewModelScope.launch {
            actorDetailViewUiState = ActorDetailViewUiState.Loading

            actorDetailViewUiState = try {
                val actor: DomainActor = actorRepository.getActorDetail(id)
                val films: List<DomainFilm> = filmRepository.getFilmListByids(actor.knownForTitles)



                ActorDetailViewUiState.Success(films, actor)

            } catch (e: Exception) {
                // Handle any exceptions that occur during data retrieval
                Log.e("Exception", e.stackTraceToString())
                ActorDetailViewUiState.Error
            }
        }
    }

    /**
     * Toggles the favorite status of a film and updates the repository.
     *
     * @param film The film for which to toggle the favorite status.
     */
    fun addFilmToFavourites(film: DomainFilm,isFavourite:Boolean) {
        film.isFavourite = !isFavourite
        viewModelScope.launch {
            filmRepository.insert(film)
        }
    }

    companion object {
        /**
         * Factory for creating an instance of [ActorDetailViewModel].
         */
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FilmApplication)
                val actorRepository = application.container.actorRepository
                val filmRepository = application.container.filmRepository

                ActorDetailViewModel(actorRepository, filmRepository)
            }
        }
    }
}
