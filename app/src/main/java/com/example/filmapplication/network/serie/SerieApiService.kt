package com.example.filmapplication.network.serie

import com.example.filmapplication.model.film.Film
import com.example.filmapplication.model.film.FilmContainer
import com.example.filmapplication.model.serie.Serie
import com.example.filmapplication.model.serie.SerieContainer
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SerieApiService {
    @GET("titles")
    suspend fun getSeries(@Query("list") list:String , @Query("startYear") startYear:Int): SerieContainer

    @GET("titles/{id}")
    suspend fun getSerieById(@Path("id") id: String): Serie
}