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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

sealed interface ActorDetailViewUiState{
    object loading: ActorDetailViewUiState
    data class Success(val films: List<DomainFilm>, val actor: DomainActor,val favFilms :List<DomainFilm> = listOf()):ActorDetailViewUiState
    object Error: ActorDetailViewUiState
}

class ActorDetailViewModel(private val actorRepository: ActorRepository, private val filmRepository: FilmRepository

):ViewModel(){
    var actorDetailViewUiState:ActorDetailViewUiState by mutableStateOf(ActorDetailViewUiState.loading)
        private set



    fun getActorDetails(id:String) {
        viewModelScope.launch {
            actorDetailViewUiState = ActorDetailViewUiState.loading

            try {
                val actor: DomainActor = actorRepository.getActorDetail(id)
                val films: List<DomainFilm> = filmRepository.getFilmListByids(actor.knownForTitles)
                var favourites :List<DomainFilm> = listOf()
               // filmRepository.getAllFavourites().collect(){favourites=it}
                actorDetailViewUiState = ActorDetailViewUiState.Success(films, actor,favourites)
            } catch (e: Exception) {

                Log.e("Exception", e.stackTraceToString())

                actorDetailViewUiState = ActorDetailViewUiState.Error
            }
        }
    }
    fun addFilmToFavourites(film:DomainFilm){
        film.isFavourite = !film.isFavourite
        viewModelScope.launch {
            filmRepository.insert(film)
        }

    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application= (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FilmApplication)
                val actorRepository = application.container.actorRepository
                val filmRepository= application.container.filmRepository

                ActorDetailViewModel(actorRepository,filmRepository)
            }
        }
    }
}
