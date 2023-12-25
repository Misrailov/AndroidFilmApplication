package com.example.filmapplication.repository

import android.util.Log
import com.example.filmapplication.data.database.actor.ActorDao
import com.example.filmapplication.data.database.actor.asDbActor
import com.example.filmapplication.data.database.actor.asDomainActor
import com.example.filmapplication.data.database.actor.asDomainActors
import com.example.filmapplication.data.database.film.asDomainFilm
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.model.actor.asDomainActor
import com.example.filmapplication.model.actor.asDomainActors
import com.example.filmapplication.network.actor.ActorApiService
import com.example.filmapplication.network.actor.getActorsAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.net.SocketTimeoutException

interface ActorRepository {

    suspend fun getActors(): List<DomainActor>

    suspend fun getActorDetail(id: String): DomainActor

    suspend fun insert(item: DomainActor)

    suspend fun update(item: DomainActor)

    suspend fun delete(item: DomainActor)

    suspend fun refresh()
    fun getAllFavourites(): Flow<List<DomainActor>>

    fun getItem(name: String): Flow<DomainActor?>

    fun getAllItems(): Flow<List<DomainActor>>


}

class CachingActorRepository(
    private val actorDao: ActorDao,
    private val actorApiService: ActorApiService
) : ActorRepository {
    override suspend fun getActors(): List<DomainActor> {
        return try {
            actorApiService.getActors().results.asDomainActors();
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            listOf()
        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
            listOf()
        }

    }

    override suspend fun getActorDetail(id: String): DomainActor {
        return try {
            actorApiService.getActorById(id).results.asDomainActor()

        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", e.stackTraceToString())
            DomainActor("", "", 0, 0, "", "")

        } catch (e: Exception) {
            Log.e("GeneralException", e.stackTraceToString())
            DomainActor("", "", 0, 0, "", "")

        }
    }

    override suspend fun refresh() {
        try {

            actorApiService.getActorsAsFlow().collect { value ->
                for (actor in value.results) {
                    var actorInDb = DomainActor("", "", 0, 0, "", "")
                    actorDao.getItem(actor.primaryName).collect() { actorInDb = it.asDomainActor() }
                    if (actorInDb.primaryName.isNotEmpty()) insert(actorInDb)
                    else insert(actor.asDomainActor())
                }
            }
        } catch (e: SocketTimeoutException) {
            //log something
        }

    }

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


    override suspend fun insert(item: DomainActor) {
        actorDao.insert(item.asDbActor())
    }

    override suspend fun update(item: DomainActor) {
        actorDao.update(item.asDbActor())

    }

    override suspend fun delete(item: DomainActor) {
        actorDao.delete(item.asDbActor())

    }


    override fun getItem(name: String): Flow<DomainActor?> {
        return actorDao.getItem(name).map { it.asDomainActor() }
    }

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

