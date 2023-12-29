package com.example.filmapplication.repository

import android.util.Log
import com.example.filmapplication.data.database.serie.SerieDao
import com.example.filmapplication.data.database.serie.asDbSerie
import com.example.filmapplication.data.database.serie.asDomainSerie
import com.example.filmapplication.domain.DomainSerie
import com.example.filmapplication.model.serie.asDomainSerie
import com.example.filmapplication.network.serie.SerieApiService
import com.example.filmapplication.network.serie.getSeriesAsFlow
import com.example.filmapplication.screens.serie.SeriePagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.net.SocketTimeoutException


/**
 * Repository interface for managing series data.
 */
interface SerieRepository {
    /**
     * Inserts a series into the local database.
     */
    suspend fun insert(item: DomainSerie)

    /**
     * Updates a series in the local database.
     */
    suspend fun update(item: DomainSerie)

    /**
     * Deletes a series from the local database.
     */
    suspend fun delete(item: DomainSerie)

    /**
     * Refreshes series data by fetching it from the remote API.
     */
    suspend fun refresh(query: String, page: Int)

    /**
     * Retrieves a series by its ID.
     */
    fun getItem(id: String): Flow<DomainSerie>

    /**
     * Retrieves a flow of all series.
     */
    fun getAllItems(query: String, page: Int): Flow<List<DomainSerie>>

    /**
     * Retrieves a flow of all favorite series.
     */
    fun getAllFavourites(): Flow<List<DomainSerie>>

    /**
     * Retrieves a list of series by fetching them from the remote API.
     */
    suspend fun getSeries(query: String, page: Int): List<DomainSerie>

    /**
     * Retrieves details of a series by its unique ID from the remote API.
     */
    suspend fun getSerieById(id: String): DomainSerie

    /**
     * Creates a paging source for series data.
     */
    fun seriePagingSource(query: String): SeriePagingSource
}

/**
 * Implementation of [SerieRepository] that caches series data.
 *
 * @property serieDao The DAO for accessing series data in the local database.
 * @property serieApiService The service for fetching series data from the API.
 */
class CachingSerieRepository(
    private val serieDao: SerieDao,
    private val serieApiService: SerieApiService
) : SerieRepository {
    /**
     * Inserts a series into the local database.
     */
    override suspend fun insert(item: DomainSerie) {
        serieDao.insert(item.asDbSerie())
    }

    /**
     * Updates a series in the local database.
     */
    override suspend fun update(item: DomainSerie) {
        serieDao.update(item.asDbSerie())
    }

    /**
     * Deletes a series from the local database.
     */
    override suspend fun delete(item: DomainSerie) {
        serieDao.delete(item.asDbSerie())
    }

    /**
     * Refreshes series data by fetching it from the remote API and updating the local database.
     */
    override suspend fun refresh(query: String, page: Int) {
        try {
            serieApiService.getSeriesAsFlow(query, page, 2010).collect() { value ->
                for (serie in value.results) {
                    insert(serie.asDomainSerie())
                }
            }
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
        }
    }

    /**
     * Retrieves a series by its ID from the local database.
     */
    override fun getItem(id: String): Flow<DomainSerie> {
        return serieDao.getItem(id).map { it.asDomainSerie() }
    }

    /**
     * Retrieves a flow of all series from the local database.
     */
    override fun getAllItems(query: String, page: Int): Flow<List<DomainSerie>> {
        return serieDao.getAllItems().map {
            it.asDomainSerie()
        }.onEach {
            if (it.isEmpty()) {
                refresh(query, page)
            }
        }
    }

    /**
     * Retrieves a flow of all favorite series from the local database.
     */
    override fun getAllFavourites(): Flow<List<DomainSerie>> {
        return try {
            serieDao.getAllItems().map {
                it.asDomainSerie().filter { it.isFavourite }
            }
        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
            flow { listOf<DomainSerie>() }
        }
    }

    /**
     * Retrieves a list of series by fetching them from the remote API.
     */
    override suspend fun getSeries(query: String, page: Int): List<DomainSerie> {
        return try {
            serieApiService.getSeries(query, page, 2010).results.map { it.asDomainSerie() }
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            listOf()
        } catch (e: Exception) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            listOf()
        }
    }

    /**
     * Retrieves details of a series by its unique ID from the remote API.
     */
    override suspend fun getSerieById(id: String): DomainSerie {
        return try {
            serieApiService.getSerieById(id).results.asDomainSerie()
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            DomainSerie()
        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
            DomainSerie()
        }
    }

    /**
     * Creates a paging source for series data.
     */
    override fun seriePagingSource(query: String): SeriePagingSource {
        return try {
            SeriePagingSource(this, query)
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            SeriePagingSource(this, query)
        } catch (e: Exception) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            SeriePagingSource(this, query)
        }
    }
}
