package com.example.filmapplication.screens.movie

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
import com.example.filmapplication.model.film.Film
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.flow.Flow


sealed interface FilmViewUiState {
    object loading: FilmViewUiState
    data class Success(val films: List<Film>) : FilmViewUiState

    object Error: FilmViewUiState

}
private const val FILMS_PER_PAGE =50

class FilmViewModel(private val filmRepository: FilmRepository):ViewModel(){

    val filmPager:Flow<PagingData<Film>> =
        Pager(config = PagingConfig(pageSize = FILMS_PER_PAGE,enablePlaceholders = false),
            pagingSourceFactory = {filmRepository.filmPagingSource("top_boxoffice_200")}).flow.cachedIn(viewModelScope)
    val filmPagerTopRated:Flow<PagingData<Film>> =
        Pager(config = PagingConfig(pageSize = FILMS_PER_PAGE,enablePlaceholders = false),
            pagingSourceFactory = {filmRepository.filmPagingSource("top_rated_english_250")}).flow.cachedIn(viewModelScope)
    val filmPagerWorstMovies:Flow<PagingData<Film>> =
        Pager(config = PagingConfig(pageSize = FILMS_PER_PAGE,enablePlaceholders = false),
            pagingSourceFactory = {filmRepository.filmPagingSource("top_rated_lowest_100")}).flow.cachedIn(viewModelScope)


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