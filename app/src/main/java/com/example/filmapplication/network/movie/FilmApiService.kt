package com.example.filmapplication.network.movie

import com.example.filmapplication.model.film.ApiFilm
import com.example.filmapplication.model.film.FilmContainer
import com.example.filmapplication.model.film.MultipleFilmsContainer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmApiService {


    @GET("titles")
    suspend fun getFilms(@Query("list") list:String,@Query("page") page:Int, @Query("startYear") startYear:Int): FilmContainer

    @GET("titles/{id}")
    suspend fun getFilmById(@Path("id") id: String): ApiFilm

    @GET("titles/x/titles-by-ids")
    suspend fun getFilmListByids(@Query("idsList") idsList: String) : MultipleFilmsContainer
}
fun FilmApiService.getFilmsAsFlow(list:String,page:Int,startYear: Int): Flow<FilmContainer> = flow{
    emit(getFilms(list,page,startYear))
}
