package com.example.filmapplication.repository

import android.util.Log
import com.example.filmapplication.data.database.actor.ActorDao
import com.example.filmapplication.data.database.actor.asDbActor
import com.example.filmapplication.data.database.actor.asDomainActor
import com.example.filmapplication.data.database.actor.asDomainActors
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.model.actor.asDomainActor
import com.example.filmapplication.model.actor.asDomainActors
import com.example.filmapplication.network.actor.ActorApiService
import com.example.filmapplication.network.actor.getActorsAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.net.SocketTimeoutException

/**
 * Repository interface for managing actor data.
 */
interface ActorRepository {
    /**
     * Retrieves a list of actors.
     */
    suspend fun getActors(): List<DomainActor>

    /**
     * Retrieves details of an actor by their unique ID.
     *
     * @param id The unique ID of the actor.
     */
    suspend fun getActorDetail(id: String): DomainActor

    /**
     * Inserts an actor into the local database.
     *
     * @param item The actor to be inserted.
     */
    suspend fun insert(item: DomainActor)

    /**
     * Updates an actor in the local database.
     *
     * @param item The updated actor data.
     */
    suspend fun update(item: DomainActor)

    /**
     * Deletes an actor from the local database.
     *
     * @param item The actor to be deleted.
     */
    suspend fun delete(item: DomainActor)

    /**
     * Refreshes the actor data by fetching it from the remote API.
     */
    suspend fun refresh()

    /**
     * Retrieves a flow of all favorite actors.
     */
    fun getAllFavourites(): Flow<List<DomainActor>>

    /**
     * Retrieves an actor by their name.
     *
     * @param name The identifier of the actor.
     */
    fun getItem(name: String): Flow<DomainActor?>

    /**
     * Retrieves a flow of all actors.
     */
    fun getAllItems(): Flow<List<DomainActor>>


}

/**
 * Implementation of [ActorRepository] that caches actor data.
 *
 * @property actorDao The DAO for accessing actor data in the local database.
 * @property actorApiService The service for fetching actor data from the API.
 */
class CachingActorRepository(
    private val actorDao: ActorDao,
    private val actorApiService: ActorApiService
) : ActorRepository {
    /**
     * Retrieves a list of actors by fetching them from the remote API.
     *
     * @return A list of [DomainActor] objects representing actors.
     */
    override suspend fun getActors(): List<DomainActor> {
        return try {
            actorApiService.getActors().results.asDomainActors()
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            listOf()
        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
            listOf()
        }

    }

    /**
     * Retrieves details of an actor by their unique ID from the remote API.
     *
     * @param id The unique ID of the actor.
     * @return A [DomainActor] object representing the actor's details.
     */
    override suspend fun getActorDetail(id: String): DomainActor {
        return try {
            actorApiService.getActorById(id).results.asDomainActor()

        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            DomainActor("", "", "0", "0", "", "")

        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
            DomainActor("", "", "0", "0", "", "")

        }
    }

    /**
     * Refreshes the actor data by fetching it from the remote API and updating the local database.
     */
    override suspend fun refresh() {
        try {
            Log.e("refresh", "refresh")
            actorApiService.getActorsAsFlow().collect { value ->
                for (actor in value.results) {
                    insert(actor.asDomainActor())
                }
            }
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
        }

    }
    /**
     * Retrieves a flow of all favorite actors from the local database.
     *
     * @return A flow of [DomainActor] objects representing favorite actors.
     */
    override fun getAllFavourites(): Flow<List<DomainActor>> {
        return try {
            actorDao.getFavourites().map {
                it.asDomainActors()
            }

        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
            flow { listOf<DomainActor>() }
        }
    }

    /**
     * Inserts an actor into the local database.
     *
     * @param item The actor to be inserted.
     */
    override suspend fun insert(item: DomainActor) {
        actorDao.insert(item.asDbActor())
    }
    /**
     * Updates an actor in the local database.
     *
     * @param item The updated actor data.
     */
    override suspend fun update(item: DomainActor) {
        actorDao.update(item.asDbActor())

    }
    /**
     * Deletes an actor from the local database.
     *
     * @param item The actor to be deleted.
     */
    override suspend fun delete(item: DomainActor) {
        actorDao.delete(item.asDbActor())

    }

    /**
     * Retrieves an actor by their name from the local database.
     *
     * @param name The name of the actor.
     * @return A flow of [DomainActor] object representing the actor.
     */
    override fun getItem(name: String): Flow<DomainActor?> {
        return actorDao.getItem(name).map { it.asDomainActor() }
    }
    /**
     * Retrieves a flow of all actors from the local database.
     *
     * @return A flow of [DomainActor] objects representing actors.
     */
    override fun getAllItems(): Flow<List<DomainActor>> {
        return actorDao.getAllItems().map {
            it.asDomainActors()
        }.onEach {
            if (it.isEmpty()) {
                refresh()

            }
        }
    }

}

