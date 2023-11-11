package com.example.filmapplication.network.actor


import com.example.filmapplication.model.actor.ActorContainer
import retrofit2.http.GET
import retrofit2.http.Path


interface ActorApiService {

@GET("api")
suspend fun getActors(): ActorContainer
}