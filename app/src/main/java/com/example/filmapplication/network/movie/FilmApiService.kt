package com.example.filmapplication.network.movie

import com.example.filmapplication.model.film.ApiFilm
import com.example.filmapplication.model.film.FilmContainer
import com.example.filmapplication.model.film.FilmContainerSingular
import com.example.filmapplication.model.film.MultipleFilmsContainer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
/**
 * Retrofit service interface for fetching film-related data from an API.
 */
interface FilmApiService {

    /**
     * Retrieves a list of films based on specified parameters.
     *
     * @param list The list name for filtering films.
     * @param page The page number for paginating results.
     * @param startYear The start year for filtering films by release year.
     * @return A [FilmContainer] containing a list of films.
     */
    @GET("titles")
    suspend fun getFilms(@Query("list") list:String,@Query("page") page:Int, @Query("startYear") startYear:Int): FilmContainer
    /**
     * Retrieves a singular film by its unique identifier.
     *
     * @param id The unique identifier of the film.
     * @return A [FilmContainerSingular] containing a single film.
     */
    @GET("titles/{id}")
    suspend fun getFilmById(@Path("id") id: String): FilmContainerSingular
    /**
     * Retrieves a list of films by their IDs.
     *
     * @param idsList A comma-separated list of film IDs.
     * @return A [MultipleFilmsContainer] containing multiple films.
     */
    @GET("titles/x/titles-by-ids")
    suspend fun getFilmListByids(@Query("idsList") idsList: String) : MultipleFilmsContainer
}
/**
 * Extension function to retrieve films as a [Flow] from [FilmApiService].
 *
 * @param list The list name for filtering films.
 * @param page The page number for paginating results.
 * @param startYear The start year for filtering films by release year.
 * @return A [Flow] emitting a [FilmContainer] containing a list of films.
 */
fun FilmApiService.getFilmsAsFlow(list:String,page:Int,startYear: Int): Flow<FilmContainer> = flow{
    emit(getFilms(list,page,startYear))
}
