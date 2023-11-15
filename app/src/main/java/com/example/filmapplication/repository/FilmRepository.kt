package com.example.filmapplication.repository

import com.example.filmapplication.model.actor.Actor
import com.example.filmapplication.model.film.Film
import com.example.filmapplication.network.actor.ActorApiService
import com.example.filmapplication.network.movie.FilmApiService
import retrofit2.http.Query

interface FilmRepository {

    suspend fun getFilms(): List<Film>
    suspend fun getFilmDetail(id:String) : Film
    /*suspend fun getActorContainer(): ActorContainer*/
//TODO : Nog zien hoe dat de container uit de API wordt verkregen
    suspend fun getFilmListByids(idsList: String) : List<Film>


}

class NetworkFilmRepository(private val filmApiService: FilmApiService): FilmRepository{
    override suspend fun getFilms(): List<Film> = filmApiService.getFilms("most_pop_movies",2010).results;
    override suspend fun getFilmDetail(id:String) : Film = filmApiService.getFilmById(id);
    override suspend fun getFilmListByids(idsList: String) : List<Film> = filmApiService.getFilmListByids(idsList).results;
}