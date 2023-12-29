//[app](../../../index.md)/[com.example.filmapplication.repository](../index.md)/[CachingFilmRepository](index.md)

# CachingFilmRepository

[androidJvm]\
class [CachingFilmRepository](index.md)(filmDao: [FilmDao](../../com.example.filmapplication.data.database.film/-film-dao/index.md), filmApiService: [FilmApiService](../../com.example.filmapplication.network.movie/-film-api-service/index.md)) : [FilmRepository](../-film-repository/index.md)

Implementation of [FilmRepository](../-film-repository/index.md) that caches film data.

## Constructors

| | |
|---|---|
| [CachingFilmRepository](-caching-film-repository.md) | [androidJvm]<br>constructor(filmDao: [FilmDao](../../com.example.filmapplication.data.database.film/-film-dao/index.md), filmApiService: [FilmApiService](../../com.example.filmapplication.network.movie/-film-api-service/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>open suspend override fun [delete](delete.md)(item: [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md))<br>Deletes a film from the local database. |
| [filmPagingSource](film-paging-source.md) | [androidJvm]<br>open override fun [filmPagingSource](film-paging-source.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FilmPagingSource](../../[root]/-film-paging-source/index.md)<br>Creates a paging source for film data. |
| [getAllFavourites](get-all-favourites.md) | [androidJvm]<br>open override fun [getAllFavourites](get-all-favourites.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;&gt;<br>Retrieves a flow of all favorite films from the local database. |
| [getAllItems](get-all-items.md) | [androidJvm]<br>open override fun [getAllItems](get-all-items.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;&gt;<br>Retrieves a flow of all films from the local database. |
| [getFilmDetail](get-film-detail.md) | [androidJvm]<br>open suspend override fun [getFilmDetail](get-film-detail.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)<br>Retrieves details of a film by its unique ID from the remote API. |
| [getFilmListByids](get-film-list-byids.md) | [androidJvm]<br>open suspend override fun [getFilmListByids](get-film-list-byids.md)(idsList: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;<br>Retrieves a list of films by their IDs from the remote API. |
| [getFilms](get-films.md) | [androidJvm]<br>open suspend override fun [getFilms](get-films.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;<br>Retrieves a list of films by fetching them from the remote API. |
| [getItem](get-item.md) | [androidJvm]<br>open override fun [getItem](get-item.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;<br>Retrieves a film by its ID from the local database. |
| [insert](insert.md) | [androidJvm]<br>open suspend override fun [insert](insert.md)(item: [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md))<br>Inserts a film into the local database. |
| [refresh](refresh.md) | [androidJvm]<br>open suspend override fun [refresh](refresh.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Refreshes film data by fetching it from the remote API and updating the local database. |
| [update](update.md) | [androidJvm]<br>open suspend override fun [update](update.md)(item: [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md))<br>Updates a film in the local database. |
