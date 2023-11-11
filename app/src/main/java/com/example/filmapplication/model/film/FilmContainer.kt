package com.example.filmapplication.model.film;

data class FilmContainer(
        val page: Int,
        val next: String,
        val entries: Int,
        val results: List<Film>
)