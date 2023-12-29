package com.example.filmapplication.screens.film

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
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.filmapplication.FilmApplication
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException


/**
 * The number of films to display per page in the paging data.
 */
private const val FILMS_PER_PAGE = 50

/**
 * ViewModel for the Film screen.
 *
 * @param filmRepository The repository for film-related data.
 */
class FilmViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    /**
     * Flow of [PagingData] for the top box office films.
     */
    val apiFilmPager: Flow<PagingData<DomainFilm>> =
        Pager(config = PagingConfig(pageSize = FILMS_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = { filmRepository.filmPagingSource("top_boxoffice_200") }).flow.cachedIn(
            viewModelScope
        )

    /**
     * Flow of [PagingData] for the top-rated films.
     */
    val apiFilmPagerTopRated: Flow<PagingData<DomainFilm>> =
        Pager(config = PagingConfig(pageSize = FILMS_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = { filmRepository.filmPagingSource("top_rated_english_250") }).flow.cachedIn(
            viewModelScope
        )

    /**
     * Flow of [PagingData] for the worst-rated movies.
     */
    val apiFilmPagerWorstMovies: Flow<PagingData<DomainFilm>> =
        Pager(config = PagingConfig(pageSize = FILMS_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = { filmRepository.filmPagingSource("top_rated_lowest_100") }).flow.cachedIn(
            viewModelScope
        )
    /**
     * Represents the state of the film-related API call.
     */
    var filmApiState: FilmApiState by mutableStateOf(FilmApiState.Loading)
        private set
    /**
     * Flow of [FilmListState] containing favorite films.
     */
    lateinit var uiListFilmState: StateFlow<FilmListState>

    init {
        getFavouriteFilms()
    }
    /**
     * Retrieves favorite films and sets the [uiListFilmState] accordingly.
     */
    fun getFavouriteFilms() {
        try {
            uiListFilmState = filmRepository.getAllFavourites().map { FilmListState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = FilmListState()
                )
            filmApiState = FilmApiState.Success
        } catch (e: IOException) {
            Log.e("IOException", e.stackTraceToString())
            filmApiState = FilmApiState.Error

        }
    }
    /**
     * Toggles the favorite status of a film and updates the database.
     *
     * @param film The film to add/remove from favorites.
     */
    fun addFilmToFavourites(film: DomainFilm) {
        film.isFavourite = !film.isFavourite
        viewModelScope.launch {
            filmRepository.insert(film)
        }

    }


    companion object {
        /**
         * Factory for creating a [FilmViewModel] instance.
         */
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FilmApplication)
                val filmRepository = application.container.filmRepository
                FilmViewModel(filmRepository)
            }
        }
    }
}