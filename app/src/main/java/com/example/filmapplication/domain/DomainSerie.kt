package com.example.filmapplication.domain

/**
 * Represents a series in the domain layer of the application.
 *
 * @property id The unique identifier for the series.
 * @property primaryImage The URL of the primary image associated with the series.
 * @property titleText The title of the series.
 * @property releaseYear The release year of the series (default is 0 if unknown).
 * @property releaseDate The release date of the series.
 * @property position The position of the series (default is 0 if not specified).
 * @property isFavourite Flag indicating if the series is marked as a favorite (default is false).
 */
data class DomainSerie(
    val id: String = "",
    val primaryImage: String = "",
    val titleText: String = "",
    val releaseYear: Int = 0,
    val releaseDate: String = "",
    val position: Int = 0,
    var isFavourite: Boolean = false
)
