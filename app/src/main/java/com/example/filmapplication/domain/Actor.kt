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
data class Person ( val nconst: String,
                    val primaryName: String,
                    val birthYear: Int,
                    val deathYear: Int,
                    val primaryProfession: String,
                    val knownForTitles: String)