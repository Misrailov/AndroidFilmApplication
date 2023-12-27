package com.example.filmapplication.domain

/**
 * Represents a film in the domain layer of the application.
 *
 * @property id The unique identifier for the film.
 * @property primaryImage The URL of the primary image associated with the film.
 * @property titleText The title of the film.
 * @property releaseYear The release year of the film (default is 0 if unknown).
 * @property releaseDate The release date of the film.
 * @property position The position of the film (default is 0 if not specified).
 * @property isFavourite Flag indicating if the film is marked as a favorite (default is false).
 */
data class DomainFilm(
    val id: String = "",
    val primaryImage: String = "",
    val titleText: String = "",
    val releaseYear: Int = 0,
    val releaseDate: String? = "",
    val position: Int = 0,
    var isFavourite: Boolean = false
)
