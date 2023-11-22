import com.example.filmapplication.model.film.Film
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmapplication.network.movie.FilmApiService
import com.example.filmapplication.repository.FilmRepository

class FilmPagingSource(val filmRepository: FilmRepository, val query:String): PagingSource<Int, Film>() {





    override suspend fun load(
      params:LoadParams<Int>):LoadResult<Int,Film>{
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

    override fun getRefreshKey(state: PagingState<Int, Film>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1) }
    }
    }
