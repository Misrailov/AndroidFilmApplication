package com.example.filmapplication.model.actor

import com.example.filmapplication.domain.DomainActor

/**
 * Represents an actor retrieved from an API.
 *
 * @property nconst The unique identifier for the actor.
 * @property primaryName The primary name of the actor.
 * @property birthYear The birth year of the actor (default is "0" if unknown).
 * @property deathYear The death year of the actor (default is "0" if alive or unknown).
 * @property primaryProfession The primary profession of the actor.
 * @property knownForTitles Titles for which the actor is known.
 */
data class ApiActor(
    val nconst: String,
    val primaryName: String,
    val birthYear: String = "0",
    val deathYear: String = "0",
    val primaryProfession: String,
    val knownForTitles: String
)



/**
 * Converts a list of [ApiActor] objects to a list of [DomainActor] objects.
 *
 * @return A list of [DomainActor] objects.
 */
fun List<ApiActor>.asDomainActors(): List<DomainActor> {
    return this.map {
        DomainActor(
            nconst = it.nconst,
            primaryName = it.primaryName,
            birthYear = it.birthYear,
            deathYear = it.deathYear,
            primaryProfession = it.primaryProfession,
            knownForTitles = it.knownForTitles
        )
    }
}

/**
 * Converts an [ApiActor] object to a [DomainActor] object.
 *
 * @return A [DomainActor] object.
 */
fun ApiActor.asDomainActor(): DomainActor {
    return DomainActor(
        nconst = this.nconst,
        primaryName = this.primaryName,
        birthYear = this.birthYear,
        deathYear = this.deathYear,
        primaryProfession = this.primaryProfession,
        knownForTitles = this.knownForTitles
    )
}
