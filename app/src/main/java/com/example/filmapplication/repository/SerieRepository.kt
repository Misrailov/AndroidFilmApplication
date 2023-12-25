package com.example.filmapplication.repository

import android.util.Log
import com.example.filmapplication.data.database.serie.SerieDao
import com.example.filmapplication.data.database.serie.asDbSerie
import com.example.filmapplication.data.database.serie.asDomainSerie
import com.example.filmapplication.domain.DomainFilm
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

interface SerieRepository {

    suspend fun insert(item:DomainSerie)
    suspend fun update(item:DomainSerie)
    suspend fun delete(item:DomainSerie)
    suspend fun refresh(query:String, page:Int)
    fun getItem(id:String): Flow<DomainSerie>
    fun getAllItems(query:String,page:Int):Flow<List<DomainSerie>>
    fun getAllFavourites():Flow<List<DomainSerie>>

    suspend fun getSeries(query:String,page:Int): List<DomainSerie>
    suspend fun getSerieById(id: String): DomainSerie
    fun seriePagingSource(query:String):SeriePagingSource

}


class CachingSerieRepository(private val serieDao: SerieDao,private val serieApiService: SerieApiService):SerieRepository{
    override suspend fun insert(item: DomainSerie) {
        serieDao.insert(item.asDbSerie())
    }

    override suspend fun update(item: DomainSerie) {
        serieDao.update(item.asDbSerie())

    }

    override suspend fun delete(item: DomainSerie) {
        serieDao.delete(item.asDbSerie())
    }

    override suspend fun refresh(query: String, page: Int) {
        try{
            serieApiService.getSeriesAsFlow(query,page,2010).collect(){
                value ->
                for(serie in value.results){
                    insert(serie.asDomainSerie())
                }
            }
        }catch (e:SocketTimeoutException){
            Log.e("SocketTimeoutException",e.stackTraceToString())
        }catch (e:Exception){
            Log.e("GeneralException",e.stackTraceToString())
        }
    }

    override fun getItem(id: String): Flow<DomainSerie> {
        return serieDao.getItem(id).map { it.asDomainSerie() }
    }

    override fun getAllItems(query: String, page: Int): Flow<List<DomainSerie>> {
    return serieDao.getAllItems().map { it.asDomainSerie()}
        .onEach {
            if(it.isEmpty()){
                refresh(query,page)
            }
        }

    }

    override fun getAllFavourites(): Flow<List<DomainSerie>> {
        return try{
            serieDao.getAllItems().map {
                it.asDomainSerie().filter { it.isFavourite }
            }

        }catch (e:Exception){
            Log.e("GeneralException",e.stackTraceToString())
            flow { listOf<DomainSerie>() }
        }
    }

    override suspend fun getSeries(query: String, page: Int): List<DomainSerie> {
        return try{
            serieApiService.getSeries(query,page,2010).results.map { it.asDomainSerie() }
        }catch (e:SocketTimeoutException){
           Log.e("SocketOutOfTimeException",e.stackTraceToString())
            listOf()
        }catch (e:Exception){
            Log.e("GeneralException",e.stackTraceToString())
            listOf()
        }

    }

    override suspend fun getSerieById(id: String): DomainSerie {
        return try{
            serieApiService.getSerieById(id).asDomainSerie()
        }catch (e:SocketTimeoutException){
            Log.e("SocketOutOfTimeException",e.stackTraceToString())
            DomainSerie()
        }catch (e:Exception){
            Log.e("GeneralException",e.stackTraceToString())
            DomainSerie()
        }

    }

    override fun seriePagingSource(query: String): SeriePagingSource {
        return try{
            SeriePagingSource(this,query)
        }catch (e:SocketTimeoutException){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            SeriePagingSource(this,query)
        }catch (e:Exception){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            SeriePagingSource(this,query)
        }

    }


}