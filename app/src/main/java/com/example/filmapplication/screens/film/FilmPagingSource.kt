package com.example.filmapplication.screens.film

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.repository.FilmRepository

/**
 * A [PagingSource] for loading paged data of films from a [FilmRepository].
 *
 * @param filmRepository The repository responsible for fetching film data.
 * @param query The query string used to search for films.
 */
class FilmPagingSource( private val filmRepository: FilmRepository, val query: String) :
    PagingSource<Int, DomainFilm>() {

    /**
     * Loads a page of paged film data.
     *
     * @param params Parameters for loading the page, including the page number.
     * @return A [LoadResult] containing the loaded data, previous and next keys, or an error.
     */
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, DomainFilm> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = filmRepository.getFilms(query, nextPageNumber)
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
     * Returns the refresh key for the PagingState.
     *
     * @param state The current [PagingState].
     * @return The refresh key, which is used to determine when to invalidate the data.
     */
    override fun getRefreshKey(state: PagingState<Int, DomainFilm>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
