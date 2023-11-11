package com.example.filmapplication.data

data class Serie(
    override  val title:String,
    override   val releaseYear: Int,
    override  val rank: Int,
    override  val Image:String,
    override val IMDBRating: String,
    //TODO: possibly seasons and episode per season


): EntertainmentMedia