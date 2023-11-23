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
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.filmapplication.FilmApplication
import com.example.filmapplication.model.serie.Serie
import com.example.filmapplication.repository.SerieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
private const val SERIES_PER_PAGE =50

sealed interface SerieViewUiState{

    object loading: SerieViewUiState
    data class Success(val series: List<Serie>):SerieViewUiState

    object Error: SerieViewUiState
}

class SerieViewModel(private val serieRepository: SerieRepository): ViewModel(){


    val seriePager: Flow<PagingData<Serie>> =
        Pager(config = PagingConfig(pageSize = SERIES_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = {serieRepository.seriePagingSource("most_pop_series")}).flow.cachedIn(viewModelScope)
    val serieTopRatedPager: Flow<PagingData<Serie>> =
        Pager(config = PagingConfig(pageSize = SERIES_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = {serieRepository.seriePagingSource("top_rated_series_250")}).flow.cachedIn(viewModelScope)

    /*var serieViewUiState: SerieViewUiState by mutableStateOf(SerieViewUiState.loading)
        private set*/

   /* init {
        getSeries()
    }*/
/*    fun getSeries(){
        viewModelScope.launch {
            serieViewUiState = SerieViewUiState.loading
            serieViewUiState = try{
                SerieViewUiState.Success(serieRepository.getSeries())

            }catch (e:Exception){
                Log.e(" SerieViewUiState", e.message.toString())
                SerieViewUiState.Error
            }
        }
    }*/
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