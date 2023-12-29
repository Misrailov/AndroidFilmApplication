package com.example.filmapplication.network.actor



import com.example.filmapplication.model.actor.ActorContainer
import com.example.filmapplication.model.actor.ActorContainerSingular

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit interface for interacting with the Actor API.
 */
interface ActorApiService {
    /**
     * Retrieves a list of actors from the API.
     *
     * @return An [ActorContainer] containing actor data.
     */
    @GET("actors")
    suspend fun getActors(): ActorContainer

    /**
     * Retrieves an actor by their ID from the API.
     *
     * @param id The ID of the actor to retrieve.
     * @return An [ActorContainerSingular] containing a single actor's data.
     */
    @GET("actors/{id}")
    suspend fun getActorById(@Path("id") id: String): ActorContainerSingular

}

/**
 * Extension function to convert the [getActors] function to a Flow.
 *
 * @return A Flow of [ActorContainer].
 */
fun ActorApiService.getActorsAsFlow(): Flow<ActorContainer> = flow {
    emit(getActors())

}

