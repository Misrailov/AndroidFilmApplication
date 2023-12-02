package com.example.filmapplication.repository

import android.util.Log
import com.example.filmapplication.data.database.actor.ActorDao
import com.example.filmapplication.data.database.actor.asDbActor
import com.example.filmapplication.data.database.actor.asDomainActor
import com.example.filmapplication.data.database.actor.asDomainActors
import com.example.filmapplication.data.database.actor.dbActor
import com.example.filmapplication.domain.DomainActor
import com.example.filmapplication.model.actor.ApiActor
import com.example.filmapplication.model.actor.asDomainActor
import com.example.filmapplication.model.actor.asDomainActors
import com.example.filmapplication.network.actor.ActorApiService
import com.example.filmapplication.network.actor.getActorsAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.net.SocketTimeoutException

interface ActorRepository {

suspend fun getActors(): List<DomainActor>
/*
suspend fun getActorDetail(id:String) : DomainActor
*/
    suspend fun insert(item: DomainActor)

    suspend fun update(item: DomainActor)

    suspend fun delete(item: DomainActor)

    suspend fun refresh()

    fun getItem(name: String): Flow<DomainActor?>

    fun getAllItems(): Flow<List<DomainActor>>



}
class CachingActorRepository(private val actorDao:ActorDao,private val actorApiService: ActorApiService):ActorRepository{
    override suspend fun getActors(): List<DomainActor> = actorApiService.getActors().results.asDomainActors();
/*
    override suspend fun getActorDetail(id: String): DomainActor =actorApiService.getActorById(id).results.asDomainActor();
*/

    override suspend fun refresh() {
            try{
                Log.i("actors" , actorApiService.getActorsAsFlow().collect{value->Log.i("ssdsd",value.results.toString())}.toString())
                actorApiService.getActorsAsFlow().collect{
                    value ->
                    for(actor in value.results){
                        Log.i("actor in refresh def", actor.primaryName)
                        insert(actor.asDomainActor())
                    }
                }
            } catch(e: SocketTimeoutException){
                //log something
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
        if(it.isEmpty()){
            refresh()

        }}
    }

}



//class NetworkActorRepository(private val actorApiService: ActorApiService):ActorRepository{
//    override suspend fun getActors(): List<ApiActor> = actorApiService.getActors().results;
//    override suspend fun getActors(): List<ApiActor> = actorApiService.getActors().results;
//}