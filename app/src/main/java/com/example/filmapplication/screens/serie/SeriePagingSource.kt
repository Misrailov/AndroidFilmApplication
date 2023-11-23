package com.example.filmapplication.screens.serie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmapplication.model.serie.Serie
import com.example.filmapplication.repository.SerieRepository

class SeriePagingSource(val serieRepository: SerieRepository, val query:String):PagingSource<Int,Serie>() {


    override suspend fun load(params:LoadParams<Int>):LoadResult<Int,Serie>{
        try{
            val nextPageNumber = params.key?:1
            val response = serieRepository.getSeries(query,nextPageNumber)
            return LoadResult.Page(data = response,
                prevKey = if(nextPageNumber==1)null else  nextPageNumber-1,
                nextKey = if (response.isEmpty())null else nextPageNumber +1
            )
        }catch (e:Exception){
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Serie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)?:
                    state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}