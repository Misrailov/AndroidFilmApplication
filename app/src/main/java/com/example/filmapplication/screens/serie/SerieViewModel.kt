package com.example.filmapplication.screens.serie

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
import com.example.filmapplication.model.serie.Serie
import com.example.filmapplication.repository.SerieRepository
import kotlinx.coroutines.launch

sealed interface SerieViewUiState{

    object loading: SerieViewUiState
    data class Success(val series: List<Serie>):SerieViewUiState

    object Error: SerieViewUiState
}

class SerieViewModel(private val serieRepository: SerieRepository): ViewModel(){
    var serieViewUiState: SerieViewUiState by mutableStateOf(SerieViewUiState.loading)
        private set

    init {
        getSeries()
    }
    fun getSeries(){
        viewModelScope.launch {
            serieViewUiState = SerieViewUiState.loading
            serieViewUiState = try{
                SerieViewUiState.Success(serieRepository.getSeries())

            }catch (e:Exception){
                Log.e(" SerieViewUiState", e.message.toString())
                SerieViewUiState.Error
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FilmApplication)
                val serieRepository = application.container.serieRepository
                SerieViewModel(serieRepository)
            }
        }
    }


}