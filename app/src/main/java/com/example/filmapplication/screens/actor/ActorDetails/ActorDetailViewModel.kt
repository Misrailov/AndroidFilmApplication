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
import com.example.filmapplication.model.actor.ApiActor
import com.example.filmapplication.model.film.Film
import com.example.filmapplication.repository.ActorRepository
import com.example.filmapplication.repository.FilmRepository
import kotlinx.coroutines.launch

sealed interface ActorDetailViewUiState{
    object loading: ActorDetailViewUiState
    data class Success(val films: List<Film>, val actor: DomainActor):ActorDetailViewUiState
    object Error: ActorDetailViewUiState
}

class ActorDetailViewModel(private val actorRepository: ActorRepository, private val filmRepository: FilmRepository

):ViewModel(){
    private var actorId :String = "nm0000005";
    var actorDetailViewUiState:ActorDetailViewUiState by mutableStateOf(ActorDetailViewUiState.loading)
        private set
    init{
        getActorDetails()


    }
    public fun SetId(id:String){
        this.actorId = id;
    }
    fun getActorDetails() {
        viewModelScope.launch {
            actorDetailViewUiState = ActorDetailViewUiState.loading
            Log.e("actorId", actorId.toString())

            try {
                Log.e("Komt hier wel", " komt hier")

                val actor: DomainActor = actorRepository.getActorDetail(actorId)

                Log.e("actor", actor.toString())
                Log.e("Komt hier ook", " komt hier")

                val films: List<Film> = filmRepository.getFilmListByids(actor.knownForTitles)
                Log.e("films", films.toString())


                actorDetailViewUiState = ActorDetailViewUiState.Success(films, actor)
            } catch (e: Exception) {
                Log.e("actorIdWhereError", actorId.toString())
                Log.e("Exception", e.toString())
                Log.e("Exception", e.stackTraceToString())

                actorDetailViewUiState = ActorDetailViewUiState.Error
            }
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
