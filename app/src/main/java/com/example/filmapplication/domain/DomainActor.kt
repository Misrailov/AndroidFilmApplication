package com.example.filmapplication.domain


enum class Role {
    ACTOR,
    DIRECTOR,
    PRODUCER,
    WRITER,
    STUNT_DOUBLE,
    BACKGROUND_FIGURE,
    CREW_MEMBER,
    OTHER_ROLE
}

data class DomainActor(
    val nconst: String,
    val primaryName: String,
    val birthYear: String = "0",
    val deathYear: String = "0",
    val primaryProfession: String,
    val knownForTitles: String,
    var isFavourite: Boolean = false
)