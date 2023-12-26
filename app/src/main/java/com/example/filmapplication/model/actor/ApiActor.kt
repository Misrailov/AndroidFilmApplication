package com.example.filmapplication.model.actor

import com.example.filmapplication.domain.DomainActor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class ApiActor(

    val nconst: String,
    val primaryName: String,
    val birthYear: String = "0",
    val deathYear: String ="0",
    val primaryProfession: String,
    val knownForTitles: String
){}

fun Flow<List<ApiActor>>.asDomainActors(): Flow<List<DomainActor>> {
    var domainlist=  this.map { it.asDomainActors() }
    return domainlist
}


fun List<ApiActor>.asDomainActors():List<DomainActor>{
    return  this.map { DomainActor(nconst=it.nconst, primaryName=it.primaryName,
        birthYear=it.birthYear,deathYear=it.deathYear.toString(),primaryProfession=it.primaryProfession,knownForTitles=it.knownForTitles)
    }}

fun  ApiActor.asDomainActor():DomainActor{
    return DomainActor(this.nconst,this.primaryName,
        this.birthYear,this.deathYear,this.primaryProfession,this.knownForTitles)
}


