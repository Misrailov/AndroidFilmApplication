package com.example.filmapplication.screens.actor

import androidx.lifecycle.ViewModel
import com.example.filmapplication.data.Actor


sealed interface ActorViewUiState{
object loading: ActorViewUiState

data class Success(val actors: List<Actor>):ActorViewUiState
    data class Error(val message : String): ActorViewUiState

}
class ActorViewModel(private val actorRepository:  ActorRepository): ViewModel() {
var ActorViewUiState: ActorViewUiState =

}