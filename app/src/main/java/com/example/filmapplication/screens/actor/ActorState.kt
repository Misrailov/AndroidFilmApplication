package com.example.filmapplication.screens.actor

import com.example.filmapplication.domain.DomainActor

data class ActorState (
    val isAddingVisible: Boolean = false,
    val scrollActionIdx: Int = 0,
    val scrollToItemIndex: Int = 0,
)
data class ActorListState(val actorList: List<DomainActor> = listOf())
sealed interface ActorApiState{
    object Success : ActorApiState
    object Error: ActorApiState
    object Loading : ActorApiState
}
