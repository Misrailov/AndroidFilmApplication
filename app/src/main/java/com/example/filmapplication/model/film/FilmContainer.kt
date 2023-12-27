package com.example.filmapplication.model.film

/**
 * Represents a container for a list of film data.
 *
 * @property page The page number associated with the data.
 * @property next The URL of the next page, if available.
 * @property entries The number of entries in the container.
 * @property results The list of [ApiFilm] objects contained in the container.
 */
data class FilmContainer(
        val page: Int,
        val next: String? = "",
        val entries: Int,
        val results: List<ApiFilm>
)
