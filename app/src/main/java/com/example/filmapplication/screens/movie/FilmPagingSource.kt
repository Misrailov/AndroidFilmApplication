import com.example.filmapplication.model.film.ApiFilm
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmapplication.domain.DomainFilm
import com.example.filmapplication.repository.FilmRepository

class FilmPagingSource(val filmRepository: FilmRepository, val query:String): PagingSource<Int, DomainFilm>() {





    override suspend fun load(
      params:LoadParams<Int>): LoadResult<Int, DomainFilm> {
        try{
            val nextPageNumber = params.key ?: 1
            val response = filmRepository.getFilms(query,nextPageNumber)
            return LoadResult.Page(
                data = response,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (response.isEmpty()) null else nextPageNumber + 1
            )
        }catch (e:Exception){
            return LoadResult.Error(e)
        }
        }

    override fun getRefreshKey(state: PagingState<Int, DomainFilm>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1) }
    }
    }
