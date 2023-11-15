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
import com.example.filmapplication.FilmApplication
import com.example.filmapplication.model.film.Film
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.launch


sealed interface FilmViewUiState {
    object loading: FilmViewUiState
    data class Success(val films: List<Film>) : FilmViewUiState

    object Error: FilmViewUiState

}

class FilmViewModel(private val filmRepository: FilmRepository):ViewModel(){

    var filmViewUiState:FilmViewUiState by mutableStateOf(FilmViewUiState.loading)
    private set

    init {
        getFilms()
    }

    fun getFilms(){
        viewModelScope.launch {
            filmViewUiState = FilmViewUiState.loading
            filmViewUiState = try{
                FilmViewUiState.Success(filmRepository.getFilms())
            }catch (e:Exception){
                FilmViewUiState.Error

            }
        }
    }

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