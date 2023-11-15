package com.example.filmapplication.repository

import android.graphics.Movie
import com.example.filmapplication.model.actor.Actor
import com.example.filmapplication.model.film.Film
import com.example.filmapplication.network.actor.ActorApiService

interface ActorRepository {

suspend fun getActors(): List<Actor>
suspend fun getActorDetail(id:String) : Actor
/*suspend fun getActorContainer(): ActorContainer*/
//TODO : Nog zien hoe dat de container uit de API wordt verkregen


}

class NetworkActorRepository(private val actorApiService: ActorApiService):ActorRepository{
    override suspend fun getActors(): List<Actor> = actorApiService.getActors().results;
    override suspend fun getActorDetail(id:String) : Actor = actorApiService.getActorById(id).results;
}