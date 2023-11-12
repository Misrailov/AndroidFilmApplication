package com.example.filmapplication.domain

data class Film (
    override  val title:String,
    override   val releaseYear: Int,
    override  val rank: Int,
    override  val Image:String,
    override val IMDBRating: String,

    ):EntertainmentMedia