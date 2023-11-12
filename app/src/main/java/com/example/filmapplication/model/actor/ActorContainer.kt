package com.example.filmapplication.model.actor

data class ActorContainer(
    val page: Int,
    val next: String?,
    val entries: Int,
    val results: List<Actor>
)
