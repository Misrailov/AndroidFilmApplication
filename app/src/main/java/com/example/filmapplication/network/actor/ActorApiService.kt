package com.example.filmapplication.network.actor


import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.model.actor.ActorContainer
import com.example.filmapplication.model.actor.ActorContainerSingular
import com.example.filmapplication.model.actor.ApiActor
import com.example.filmapplication.model.actor.asDomainActors
import com.example.filmapplication.model.actor.getList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path


interface ActorApiService {

    @GET("actors")
    suspend fun getActors(): ActorContainer

    @GET("actors/{id}")
    suspend fun getActorById(@Path("id") id: String): ActorContainerSingular

}
fun ActorApiService.getActorsAsFlow(): Flow<ActorContainer> = flow{
    emit(getActors())

}

