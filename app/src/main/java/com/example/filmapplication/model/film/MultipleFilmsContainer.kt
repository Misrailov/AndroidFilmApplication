package com.example.filmapplication.model.film

/**
 * Represents a container for multiple film data entries.
 *
 * @property entries The number of entries in the container.
 * @property results The list of [ApiFilm] objects contained in the container.
 */
data class MultipleFilmsContainer(
    val entries: Int,
    val results: List<ApiFilm>
)
