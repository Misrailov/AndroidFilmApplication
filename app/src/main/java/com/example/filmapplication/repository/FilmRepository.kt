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

interface FilmRepository {

    suspend fun insert(item:DomainFilm)
    suspend fun update(item:DomainFilm)
    suspend fun delete(item:DomainFilm)
    suspend fun refresh(query: String, page: Int)
    fun getItem(id:String): Flow<DomainFilm>
    fun getAllItems(query: String, page: Int):Flow<List<DomainFilm>>
    fun getAllFavourites():Flow<List<DomainFilm>>

    suspend fun getFilms(query: String, page: Int): List<DomainFilm>
    suspend fun getFilmDetail(id: String): DomainFilm
    suspend fun getFilmListByids(idsList: String): List<DomainFilm>
    fun filmPagingSource(query: String): FilmPagingSource


}


class CachingFilmRepository(
    private val filmDao: FilmDao,
    private val filmApiService: FilmApiService
):FilmRepository{
    override suspend fun insert(item: DomainFilm) {
        Log.e("filmTOAdd",item.toString())


        filmDao.insert(item.asDbFilm())

    }

    override suspend fun update(item: DomainFilm) {
        filmDao.update(item.asDbFilm())
    }

    override suspend fun delete(item: DomainFilm) {
        filmDao.delete(item.asDbFilm())

    }

    override suspend fun refresh(query: String, page: Int) {
        try{
            filmApiService.getFilmsAsFlow(query, page, 2010).collect(){
                value->
                for(film in value.results){
                    insert(film.asDomainFilm())
                }
            }
        }catch (e:SocketTimeoutException){
            Log.e("SocketTimeoutException",e.stackTraceToString())
        }catch (e:Exception){
            Log.e("Exception",e.stackTraceToString())

        }
    }

    override fun getItem(id: String): Flow<DomainFilm> {
        return filmDao.getItem(id).map { it.asDomainFilm() }
    }

    override fun getAllItems(query: String, page: Int): Flow<List<DomainFilm>> {
        return filmDao.getAllItems().map {
            it.asDomainFilm()
        }.onEach {
            if(it.isEmpty()){
                refresh(query, page)
            }
        }
    }

    override fun getAllFavourites(): Flow<List<DomainFilm>> {
        return try{
            filmDao.getAllItems().map {
                it.asDomainFilm().filter { it.isFavourite }
            }
        }catch (e:Exception){
            Log.e("GeneralException",e.stackTraceToString())
            flow { listOf<DomainFilm>() }
        }
    }

    override suspend fun getFilms(query: String, page: Int): List<DomainFilm> {
        return try{
            filmApiService.getFilms(query, page, 2010).results.map { it.asDomainFilm() }
        }catch (e:SocketTimeoutException){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            listOf()
        }catch (e:Exception){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            listOf()
        }
    }

    override suspend fun getFilmDetail(id: String): DomainFilm {
        return try{
            filmApiService.getFilmById(id).asDomainFilm()
        }catch (e:SocketTimeoutException){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            DomainFilm("","","",0,"",0)

        }catch (e:Exception){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            DomainFilm("","","",0,"",0)
        }
    }

    override suspend fun getFilmListByids(idsList: String): List<DomainFilm> {
        return try{
            filmApiService.getFilmListByids(idsList).results.map { it.asDomainFilm() }
        }catch (e:SocketTimeoutException){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            listOf()
        }catch (e:Exception){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            listOf()

        }
    }

    override fun filmPagingSource(query: String): FilmPagingSource {
        return try{
             FilmPagingSource(this, query)
        }catch (e:SocketTimeoutException){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            FilmPagingSource(this, query)

        }catch (e:Exception){
            Log.e("SocketTimeoutException",e.stackTraceToString())
            FilmPagingSource(this, query)

        }
    }

}