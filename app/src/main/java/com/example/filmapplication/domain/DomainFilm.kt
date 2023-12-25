package com.example.filmapplication.domain

data class DomainFilm(
    val id: String = "",
    val primaryImage: String = "",
    val titleText: String = "",
    val releaseYear: Int = 0,
    val releaseDate: String = "",
    val position: Int = 0,
    var isFavourite: Boolean = false
)

