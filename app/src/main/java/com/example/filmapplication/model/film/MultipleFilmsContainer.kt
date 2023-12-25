package com.example.filmapplication.model.film

data class MultipleFilmsContainer( val entries: Int,
                                   val results: List<ApiFilm>
)