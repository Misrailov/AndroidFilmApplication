package com.example.filmapplication.screens.serie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmapplication.domain.DomainSerie
import com.example.filmapplication.repository.SerieRepository

/**
 * A [PagingSource] implementation for loading paged TV series data.
 *
 * @param serieRepository The repository responsible for fetching TV series data.
 * @param query The query string to filter the TV series.
 */
class SeriePagingSource(private val serieRepository: SerieRepository, val query: String) :
    PagingSource<Int, DomainSerie>() {

    /**
     * Loads a page of TV series data based on the provided parameters.
     *
     * @param params The load parameters including the page key.
     * @return A [LoadResult] containing the loaded TV series data or an error.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DomainSerie> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = serieRepository.getSeries(query, nextPageNumber)
            LoadResult.Page(
                data = response,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (response.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    /**
     * Returns the refresh key for the current state, used to determine the starting point
     * for loading when refreshing the data.
     *
     * @param state The current paging state.
     * @return The refresh key.
     */
    override fun getRefreshKey(state: PagingState<Int, DomainSerie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}