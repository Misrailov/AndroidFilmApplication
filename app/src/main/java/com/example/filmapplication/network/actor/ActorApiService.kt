package com.example.filmapplication.network.actor


import com.example.filmapplication.model.actor.ActorContainer
import com.example.filmapplication.model.actor.ActorContainerSingular
import retrofit2.http.GET
import retrofit2.http.Path


interface ActorApiService {

    @GET("actors")
    suspend fun getActors(): ActorContainer

    @GET("actors/{id}")
    suspend fun getActorById(@Path("id") id: String): ActorContainerSingular
}
