package com.example.filmapplication.repository

import com.example.filmapplication.data.Actor

interface ActorRepository {

suspend fun getActors(): List<Actor>
suspend fun getActorDetail(id:Int) :Actor
/*suspend fun getActorContainer(): ActorContainer*/
//TODO : Nog zien hoe dat de container uit de API wordt verkregen

}