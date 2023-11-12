package com.example.filmapplication.network.actor


import com.example.filmapplication.model.actor.Actor
import com.example.filmapplication.model.actor.ActorContainer
import retrofit2.http.GET
import retrofit2.http.Path


interface ActorApiService {

    @GET("actors")
    suspend fun getActors(): ActorContainer

    @GET("actors/{id}")
    suspend fun getActorById(@Path("id") id: String): Actor
}
