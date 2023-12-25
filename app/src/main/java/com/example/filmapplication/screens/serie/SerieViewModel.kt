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
import com.example.filmapplication.domain.DomainSerie
import com.example.filmapplication.repository.SerieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException

private const val SERIES_PER_PAGE = 50

class SerieViewModel(private val serieRepository: SerieRepository) : ViewModel() {

    val seriePager: Flow<PagingData<DomainSerie>> =
        Pager(config = PagingConfig(pageSize = SERIES_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = { serieRepository.seriePagingSource("most_pop_series") }).flow.cachedIn(
            viewModelScope
        )
    val serieTopRatedPager: Flow<PagingData<DomainSerie>> =
        Pager(config = PagingConfig(pageSize = SERIES_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = { serieRepository.seriePagingSource("top_rated_series_250") }).flow.cachedIn(
            viewModelScope
        )

    var serieApiState: SerieApiState by mutableStateOf(SerieApiState.Loading)
        private set
    private val _uiState = MutableStateFlow(SerieState())
    lateinit var uiListSerieState: StateFlow<SerieListState>

    init {
        getFavouriteSeries()
    }

    fun getFavouriteSeries() {
        try {
            uiListSerieState = serieRepository.getAllFavourites().map { SerieListState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = SerieListState()
                )
            serieApiState = SerieApiState.Success
        }catch (e:IOException){
            Log.e("IOException", e.stackTraceToString())
            serieApiState =SerieApiState.Error
        }
    }
    fun addSerieToFavourites(serie:DomainSerie){
        serie.isFavourite = !serie.isFavourite
        viewModelScope.launch {
            serieRepository.insert(serie)
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FilmApplication)
                val serieRepository = application.container.serieRepository
                SerieViewModel(serieRepository)
            }
        }
    }


}