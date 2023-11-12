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
data class Person (val actorName: String, val playedIn: List<String>, val images: List<String>, val birthDate: String, val role: Role )