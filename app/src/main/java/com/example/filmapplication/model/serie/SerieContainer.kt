package com.example.filmapplication.model.serie

/**
 * Represents a container for a list of series data.
 *
 * @property page The page number associated with the data.
 * @property next The URL of the next page, if available.
 * @property entries The number of entries in the container.
 * @property results The list of [ApiSerie] objects contained in the container.
 */
data class SerieContainer(
    val page: Int,
    val next: String,
    val entries: Int,
    val results: List<ApiSerie>
)
