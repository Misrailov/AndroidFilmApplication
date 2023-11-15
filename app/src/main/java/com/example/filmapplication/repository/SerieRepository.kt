package com.example.filmapplication.repository

import android.util.Log
import com.example.filmapplication.model.serie.Serie
import com.example.filmapplication.network.serie.SerieApiService

interface SerieRepository {

    suspend fun getSeries(): List<Serie>
    suspend fun getSerieById(id: String): Serie
    // Add more functions as needed

}

class NetworkSerieRepository(private val serieApiService: SerieApiService) : SerieRepository {
    override suspend fun getSeries(): List<Serie> {
        return try{
        serieApiService.getSeries("top_rated_series_250",1975).results}catch (e:Exception){
            Log.e("NetworkSerieRepository",serieApiService.getSeries("top_rated_series_250",1975).results.toString())
            emptyList()
        }}
    override suspend fun getSerieById(id: String): Serie = serieApiService.getSerieById(id)
    // Implement other functions
}
