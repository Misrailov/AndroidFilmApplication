package com.example.filmapplication.domain

import com.example.filmapplication.model.film.TitleText

data class DomainSerie(
    val id: String = "",
    val primaryImage: String = "",
    val titleText: String = "",
    val releaseYear: Int = 0,
    val releaseDate: String = "",
    val position: Int = 0,
    var isFavourite: Boolean = false

)