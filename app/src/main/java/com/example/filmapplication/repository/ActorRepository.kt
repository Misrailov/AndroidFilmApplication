package com.example.filmapplication.repository

import com.example.filmapplication.model.actor.Actor
import com.example.filmapplication.network.actor.ActorApiService

interface ActorRepository {

suspend fun getActors(): List<Actor>
suspend fun getActorDetail(id:String) : Actor




}

class NetworkActorRepository(private val actorApiService: ActorApiService):ActorRepository{
    override suspend fun getActors(): List<Actor> = actorApiService.getActors().results;
    override suspend fun getActorDetail(id:String) : Actor = actorApiService.getActorById(id).results;
}