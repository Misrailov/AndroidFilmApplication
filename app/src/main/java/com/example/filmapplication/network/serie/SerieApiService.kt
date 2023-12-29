package com.example.filmapplication.network.serie

import com.example.filmapplication.model.serie.ApiSerie
import com.example.filmapplication.model.serie.SerieContainer
import com.example.filmapplication.model.serie.SerieContainerSingular
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
/**
 * Retrofit service interface for fetching series-related data from an API.
 */
interface SerieApiService {
    /**
     * Retrieves a list of series based on specified parameters.
     *
     * @param list The list name for filtering series.
     * @param page The page number for paginating results.
     * @param startYear The start year for filtering series by release year.
     * @return A [SerieContainer] containing a list of series.
     */
    @GET("titles")
    suspend fun getSeries(@Query("list") list:String ,@Query("page")page:Int, @Query("startYear") startYear:Int): SerieContainer
    /**
     * Retrieves a singular series by its unique identifier.
     *
     * @param id The unique identifier of the series.
     * @return A [SerieContainerSingular] containing a single series.
     */
    @GET("titles/{id}")
    suspend fun getSerieById(@Path("id") id: String): SerieContainerSingular
}
/**
 * Extension function to retrieve series as a [Flow] from [SerieApiService].
 *
 * @param list The list name for filtering series.
 * @param page The page number for paginating results.
 * @param startYear The start year for filtering series by release year.
 * @return A [Flow] emitting a [SerieContainer] containing a list of series.
 */
fun SerieApiService.getSeriesAsFlow(list:String,page:Int,startYear: Int): Flow<SerieContainer> =
    flow { emit(getSeries(list,page,startYear)) }