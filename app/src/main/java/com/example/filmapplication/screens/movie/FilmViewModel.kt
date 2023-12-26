package com.example.filmapplication.screens.movie

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
import com.example.filmapplication.model.film.ApiFilm
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface FilmViewUiState {
    object loading: FilmViewUiState
    data class Success(val apiFilms: List<DomainFilm>) : FilmViewUiState
    object Error: FilmViewUiState
}
private const val FILMS_PER_PAGE =50

class FilmViewModel(private val filmRepository: FilmRepository):ViewModel(){

    val apiFilmPager:Flow<PagingData<DomainFilm>> =
        Pager(config = PagingConfig(pageSize = FILMS_PER_PAGE,enablePlaceholders = false),
            pagingSourceFactory = {filmRepository.filmPagingSource("top_boxoffice_200")}).flow.cachedIn(viewModelScope)
    val apiFilmPagerTopRated:Flow<PagingData<DomainFilm>> =
        Pager(config = PagingConfig(pageSize = FILMS_PER_PAGE,enablePlaceholders = false),
            pagingSourceFactory = {filmRepository.filmPagingSource("top_rated_english_250")}).flow.cachedIn(viewModelScope)
    val apiFilmPagerWorstMovies:Flow<PagingData<DomainFilm>> =
        Pager(config = PagingConfig(pageSize = FILMS_PER_PAGE,enablePlaceholders = false),
            pagingSourceFactory = {filmRepository.filmPagingSource("top_rated_lowest_100")}).flow.cachedIn(viewModelScope)

    var filmApiState:FilmApiState by mutableStateOf(FilmApiState.Loading)
        private set
    private val _uiState = MutableStateFlow(FilmState())
    lateinit var uiListFilmState: StateFlow<FilmListState>

    init{
        getFavouriteFilms()
    }

    fun getFavouriteFilms(){
        try{
            uiListFilmState = filmRepository.getAllFavourites().map {FilmListState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = FilmListState()
                    )
            filmApiState = FilmApiState.Success
        }catch (e:IOException){
            Log.e("IOException",e.stackTraceToString())
            filmApiState =FilmApiState.Error

        }
    }

    fun addFilmToFavourites(film:DomainFilm){
        film.isFavourite = !film.isFavourite
        viewModelScope.launch {
            filmRepository.insert(film)
        }

    }

    var filmViewUiState:FilmViewUiState by mutableStateOf(FilmViewUiState.loading)
    private set


    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application= (this[APPLICATION_KEY] as FilmApplication)
                val filmRepository = application.container.filmRepository
                FilmViewModel(filmRepository)
            }
        }
    }
}