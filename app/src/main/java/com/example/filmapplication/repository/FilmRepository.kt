package com.example.filmapplication.repository

import FilmPagingSource
import android.util.Log
import com.example.filmapplication.data.database.film.FilmDao
import com.example.filmapplication.data.database.film.asDbFilm
import com.example.filmapplication.data.database.film.asDomainFilm
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.model.film.ApiFilm
import com.example.filmapplication.model.film.asDomainFilm
import com.example.filmapplication.network.movie.FilmApiService
import com.example.filmapplication.network.movie.getFilmsAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.net.SocketTimeoutException
/**
 * Repository interface for managing film data.
 */
interface FilmRepository {
    /**
     * Inserts a film into the local database.
     */
    suspend fun insert(item: DomainFilm)

    /**
     * Updates a film in the local database.
     */
    suspend fun update(item: DomainFilm)

    /**
     * Deletes a film from the local database.
     */
    suspend fun delete(item: DomainFilm)

    /**
     * Refreshes film data by fetching it from the remote API.
     */
    suspend fun refresh(query: String, page: Int)

    /**
     * Retrieves a film by its ID.
     */
    fun getItem(id: String): Flow<DomainFilm>

    /**
     * Retrieves a flow of all films.
     */
    fun getAllItems(query: String, page: Int): Flow<List<DomainFilm>>

    /**
     * Retrieves a flow of all favorite films.
     */
    fun getAllFavourites(): Flow<List<DomainFilm>>

    /**
     * Retrieves a list of films by fetching them from the remote API.
     */
    suspend fun getFilms(query: String, page: Int): List<DomainFilm>

    /**
     * Retrieves details of a film by its unique ID from the remote API.
     */
    suspend fun getFilmDetail(id: String): DomainFilm

    /**
     * Retrieves a list of films by their IDs from the remote API.
     */
    suspend fun getFilmListByids(idsList: String): List<DomainFilm>

    /**
     * Creates a paging source for film data.
     */
    fun filmPagingSource(query: String): FilmPagingSource
}


/**
 * Implementation of [FilmRepository] that caches film data.
 *
 * @property filmDao The DAO for accessing film data in the local database.
 * @property filmApiService The service for fetching film data from the API.
 */
class CachingFilmRepository(
    private val filmDao: FilmDao,
    private val filmApiService: FilmApiService
) : FilmRepository {
    /**
     * Inserts a film into the local database.
     */
    override suspend fun insert(item: DomainFilm) {
        Log.e("filmTOAdd", item.toString())
        filmDao.insert(item.asDbFilm())
    }

    /**
     * Updates a film in the local database.
     */
    override suspend fun update(item: DomainFilm) {
        filmDao.update(item.asDbFilm())
    }

    /**
     * Deletes a film from the local database.
     */
    override suspend fun delete(item: DomainFilm) {
        filmDao.delete(item.asDbFilm())
    }

    /**
     * Refreshes film data by fetching it from the remote API and updating the local database.
     */
    override suspend fun refresh(query: String, page: Int) {
        try {
            filmApiService.getFilmsAsFlow(query, page, 2010).collect() { value ->
                for (film in value.results) {
                    insert(film.asDomainFilm())
                }
            }
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
        } catch (e: Exception) {
            Log.e("Exception", e.stackTraceToString())
        }
    }

    /**
     * Retrieves a film by its ID from the local database.
     */
    override fun getItem(id: String): Flow<DomainFilm> {
        return filmDao.getItem(id).map { it.asDomainFilm() }
    }

    /**
     * Retrieves a flow of all films from the local database.
     */
    override fun getAllItems(query: String, page: Int): Flow<List<DomainFilm>> {
        return filmDao.getAllItems().map {
            it.asDomainFilm()
        }.onEach {
            if (it.isEmpty()) {
                refresh(query, page)
            }
        }
    }

    /**
     * Retrieves a flow of all favorite films from the local database.
     */
    override fun getAllFavourites(): Flow<List<DomainFilm>> {
        return try {
            filmDao.getAllItems().map {
                it.asDomainFilm().filter { it.isFavourite }
            }
        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
            flow { listOf<DomainFilm>() }
        }
    }

    /**
     * Retrieves a list of films by fetching them from the remote API.
     */
    override suspend fun getFilms(query: String, page: Int): List<DomainFilm> {
        return try {
            filmApiService.getFilms(query, page, 2010).results.map { it.asDomainFilm() }
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            listOf()
        } catch (e: Exception) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            listOf()
        }
    }

    /**
     * Retrieves details of a film by its unique ID from the remote API.
     */
    override suspend fun getFilmDetail(id: String): DomainFilm {
        return try {
            filmApiService.getFilmById(id).results.asDomainFilm()
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            DomainFilm("", "", "", 0, "", 0)
        } catch (e: Exception) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            DomainFilm("", "", "", 0, "", 0)
        }
    }

    /**
     * Retrieves a list of films by their IDs from the remote API.
     */
    override suspend fun getFilmListByids(idsList: String): List<DomainFilm> {
        return try {
            filmApiService.getFilmListByids(idsList).results.map { it.asDomainFilm() }
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            listOf()
        } catch (e: Exception) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            listOf()
        }
    }

    /**
     * Creates a paging source for film data.
     */
    override fun filmPagingSource(query: String): FilmPagingSource {
        return try {
            FilmPagingSource(this, query)
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            FilmPagingSource(this, query)
        } catch (e: Exception) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            FilmPagingSource(this, query)
        }
    }
}