package com.example.filmapplication.screens.actor

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
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.IOException


class ActorViewModel(private val actorRepository: ActorRepository, private val filmRepository: FilmRepository): ViewModel() {
var actorApiState: ActorApiState by mutableStateOf(ActorApiState.Loading)
    private set

    private val _uiState = MutableStateFlow(ActorState())
    val uiState:StateFlow<ActorState> = _uiState.asStateFlow()

    lateinit var uiListActorState: StateFlow<ActorListState>
    init{
        getRepoActors()
        Log.i("vm inspection", "ActorViewModel init")
        Log.i("actors in init", uiListActorState.map { it.actorList[0] }.toString())

    }

    fun getRepoActors(){
        try{
            viewModelScope.launch { actorRepository.refresh() }
            uiListActorState = actorRepository.getAllItems().map { ActorListState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = ActorListState()
                )
            actorApiState= ActorApiState.Success
        }catch (e:IOException){
            actorApiState = ActorApiState.Error

        }
    }


 /*   fun getActors(){
        viewModelScope.launch {
            actorViewUiState = ActorViewUiState.loading
            actorViewUiState = try{
                ActorViewUiState.Success(actorRepository.getActors())
            }catch (e:Exception){
                ActorViewUiState.Error
            }
        }
    }*/

 /*   fun getMoviesForActor(actorId: String) {
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
    }*/
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