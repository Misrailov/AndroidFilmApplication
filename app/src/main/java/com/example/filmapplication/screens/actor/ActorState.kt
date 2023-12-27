package com.example.filmapplication.screens.actor

import com.example.filmapplication.domain.DomainActor
/**
 * Represents the state of the actor screen.
 *
 * @property scrollActionIdx An integer representing a scroll action index.
 * @property scrollToItemIndex An integer representing the index of the item to which the screen should scroll.
 */
data class ActorState(
    val scrollActionIdx: Int = 0,
    val scrollToItemIndex: Int = 0
)

/**
 * Represents the state of the actor list within the actor screen.
 *
 * @property actorList A list of [DomainActor] objects representing the list of actors to be displayed.
 * @property favouriteActors A list of [DomainActor] objects representing the list of favorite actors.
 */
data class ActorListState(
    val actorList: List<DomainActor> = listOf(),
    val favouriteActors: List<DomainActor> = listOf()
)

/**
 * Sealed interface defining possible states for the API calls related to actors.
 */
sealed interface ActorApiState {
    /**
     * Indicates a successful API call.
     */
    object Success : ActorApiState

    /**
     * Indicates an error occurred during the API call.
     */
    object Error : ActorApiState

    /**
     * Indicates that the API call is in progress.
     */
    object Loading : ActorApiState
}
