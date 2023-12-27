package com.example.filmapplication.domain

/**
 * Represents an actor in the domain layer of the application.
 *
 * @property nconst The unique identifier for the actor.
 * @property primaryName The primary name of the actor.
 * @property birthYear The birth year of the actor (default is "0" if unknown).
 * @property deathYear The death year of the actor (default is "0" if alive or unknown).
 * @property primaryProfession The primary profession of the actor.
 * @property knownForTitles Titles for which the actor is known.
 * @property isFavourite Flag indicating if the actor is marked as a favorite (default is false).
 */
data class DomainActor(
    val nconst: String,
    val primaryName: String,
    val birthYear: String = "0",
    val deathYear: String = "0",
    val primaryProfession: String,
    val knownForTitles: String,
    var isFavourite: Boolean = false
)
