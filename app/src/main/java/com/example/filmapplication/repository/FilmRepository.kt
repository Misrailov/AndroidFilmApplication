package com.example.filmapplication.repository

import FilmPagingSource
import com.example.filmapplication.model.film.Film
import com.example.filmapplication.network.movie.FilmApiService

interface FilmRepository {

    suspend fun getFilms(query:String, page:Int): List<Film>
    suspend fun getFilmDetail(id:String) : Film
    suspend fun getFilmListByids(idsList: String) : List<Film>
     fun filmPagingSource(query:String): FilmPagingSource


}

class NetworkFilmRepository(private val filmApiService: FilmApiService): FilmRepository{
    override suspend fun getFilms(query:String, page:Int): List<Film> = filmApiService.getFilms(query,page,2010).results;
    override suspend fun getFilmDetail(id:String) : Film = filmApiService.getFilmById(id);
    override suspend fun getFilmListByids(idsList: String) : List<Film> = filmApiService.getFilmListByids(idsList).results;
    override  fun filmPagingSource(query:String): FilmPagingSource {
        return FilmPagingSource(this,query)
    }
}