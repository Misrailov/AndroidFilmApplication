package com.example.filmapplication.model.film
/**
 * Represents a container for a singular film result received from an API.
 *
 * @property results The [ApiFilm] object representing the singular film result.
 */
data class FilmContainerSingular (
    val results:ApiFilm
)