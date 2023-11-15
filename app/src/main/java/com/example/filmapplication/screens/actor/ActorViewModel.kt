package com.example.filmapplication.screens.actor

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
import com.example.filmapplication.model.actor.Actor
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.launch
import java.lang.Exception


sealed interface ActorViewUiState{
object loading: ActorViewUiState

data class Success(val actors: List<Actor>):ActorViewUiState
    object Error: ActorViewUiState

}
class ActorViewModel(private val actorRepository: ActorRepository, private val filmRepository: FilmRepository): ViewModel() {
var actorViewUiState: ActorViewUiState by mutableStateOf(ActorViewUiState.loading)
    private set
    init{
        getActors()
    }
    fun getActors(){
        viewModelScope.launch {
            actorViewUiState = ActorViewUiState.loading
            actorViewUiState = try{
                ActorViewUiState.Success(actorRepository.getActors())
            }catch (e:Exception){
                ActorViewUiState.Error
            }
        }
    }

    fun getMoviesForActor(actorId: String) {
        viewModelScope.launch {
            actorViewUiState = ActorViewUiState.loading
            actorViewUiState = try {
                val actor = actorRepository.getActorDetail(actorId)
                val movies = filmRepository.getFilmListByids(actor.knownForTitles)
                // Now you have the movies, update the UI state or do something with them
                ActorViewUiState.Success(emptyList())
            } catch (e: Exception) {
                ActorViewUiState.Error
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application= (this[APPLICATION_KEY] as FilmApplication)
                val actorRepository = application.container.actorRepository
                val filmRepository= application.container.filmRepository

                ActorViewModel(actorRepository,filmRepository)
            }
        }
    }

}