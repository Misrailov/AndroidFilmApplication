package com.example.filmapplication.network.movie

import com.example.filmapplication.model.film.Film
import com.example.filmapplication.model.film.FilmContainer
import com.example.filmapplication.model.film.MultipleFilmsContainer
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmApiService {


    @GET("titles")
    suspend fun getFilms(@Query("list") list:String , @Query("startYear") startYear:Int): FilmContainer

    @GET("titles/{id}")
    suspend fun getFilmById(@Path("id") id: String): Film

    @GET("titles/x/titles-by-ids")
    suspend fun getFilmListByids(@Query("idsList") idsList: String) : MultipleFilmsContainer
}
