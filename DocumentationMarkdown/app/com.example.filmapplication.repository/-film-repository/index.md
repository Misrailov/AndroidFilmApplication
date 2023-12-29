//[app](../../../index.md)/[com.example.filmapplication.repository](../index.md)/[FilmRepository](index.md)

# FilmRepository

interface [FilmRepository](index.md)

Repository interface for managing film data.

#### Inheritors

| |
|---|
| [CachingFilmRepository](../-caching-film-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md))<br>Deletes a film from the local database. |
| [filmPagingSource](film-paging-source.md) | [androidJvm]<br>abstract fun [filmPagingSource](film-paging-source.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FilmPagingSource](../../[root]/-film-paging-source/index.md)<br>Creates a paging source for film data. |
| [getAllFavourites](get-all-favourites.md) | [androidJvm]<br>abstract fun [getAllFavourites](get-all-favourites.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;&gt;<br>Retrieves a flow of all favorite films. |
| [getAllItems](get-all-items.md) | [androidJvm]<br>abstract fun [getAllItems](get-all-items.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;&gt;<br>Retrieves a flow of all films. |
| [getFilmDetail](get-film-detail.md) | [androidJvm]<br>abstract suspend fun [getFilmDetail](get-film-detail.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)<br>Retrieves details of a film by its unique ID from the remote API. |
| [getFilmListByids](get-film-list-byids.md) | [androidJvm]<br>abstract suspend fun [getFilmListByids](get-film-list-byids.md)(idsList: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;<br>Retrieves a list of films by their IDs from the remote API. |
| [getFilms](get-films.md) | [androidJvm]<br>abstract suspend fun [getFilms](get-films.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;<br>Retrieves a list of films by fetching them from the remote API. |
| [getItem](get-item.md) | [androidJvm]<br>abstract fun [getItem](get-item.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;<br>Retrieves a film by its ID. |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md))<br>Inserts a film into the local database. |
| [refresh](refresh.md) | [androidJvm]<br>abstract suspend fun [refresh](refresh.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Refreshes film data by fetching it from the remote API. |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(item: [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md))<br>Updates a film in the local database. |
