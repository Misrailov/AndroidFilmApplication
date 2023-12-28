package com.example.filmapplication.network.serie

import com.example.filmapplication.model.serie.ApiSerie
import com.example.filmapplication.model.serie.SerieContainer
import com.example.filmapplication.model.serie.SerieContainerSingular
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SerieApiService {
    @GET("titles")
    suspend fun getSeries(@Query("list") list:String ,@Query("page")page:Int, @Query("startYear") startYear:Int): SerieContainer

    @GET("titles/{id}")
    suspend fun getSerieById(@Path("id") id: String): SerieContainerSingular
}

fun SerieApiService.getSeriesAsFlow(list:String,page:Int,startYear: Int): Flow<SerieContainer> =
    flow { emit(getSeries(list,page,startYear)) }