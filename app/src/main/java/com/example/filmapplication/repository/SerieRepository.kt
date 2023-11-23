package com.example.filmapplication.repository

import android.util.Log
import com.example.filmapplication.model.serie.Serie
import com.example.filmapplication.network.serie.SerieApiService
import com.example.filmapplication.screens.serie.SeriePagingSource

interface SerieRepository {

    suspend fun getSeries(query:String,page:Int): List<Serie>
    suspend fun getSerieById(id: String): Serie
    // Add more functions as needed
    fun seriePagingSource(query:String):SeriePagingSource

}

class NetworkSerieRepository(private val serieApiService: SerieApiService) : SerieRepository {
    override suspend fun getSeries(query:String,page:Int): List<Serie> {
        return try{
        serieApiService.getSeries(query,page,1975).results}catch (e:Exception){
            Log.e("NetworkSerieRepository",serieApiService.getSeries("top_rated_series_250",page,1975).results.toString())
            emptyList()
        }}
    override suspend fun getSerieById(id: String): Serie = serieApiService.getSerieById(id)
    override fun seriePagingSource(query: String): SeriePagingSource {
        return SeriePagingSource(this,query)
    }
    // Implement other functions
}
