//[app](../../../index.md)/[com.example.filmapplication.repository](../index.md)/[SerieRepository](index.md)

# SerieRepository

interface [SerieRepository](index.md)

Repository interface for managing series data.

#### Inheritors

| |
|---|
| [CachingSerieRepository](../-caching-serie-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md))<br>Deletes a series from the local database. |
| [getAllFavourites](get-all-favourites.md) | [androidJvm]<br>abstract fun [getAllFavourites](get-all-favourites.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;&gt;<br>Retrieves a flow of all favorite series. |
| [getAllItems](get-all-items.md) | [androidJvm]<br>abstract fun [getAllItems](get-all-items.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;&gt;<br>Retrieves a flow of all series. |
| [getItem](get-item.md) | [androidJvm]<br>abstract fun [getItem](get-item.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;<br>Retrieves a series by its ID. |
| [getSerieById](get-serie-by-id.md) | [androidJvm]<br>abstract suspend fun [getSerieById](get-serie-by-id.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)<br>Retrieves details of a series by its unique ID from the remote API. |
| [getSeries](get-series.md) | [androidJvm]<br>abstract suspend fun [getSeries](get-series.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;<br>Retrieves a list of series by fetching them from the remote API. |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md))<br>Inserts a series into the local database. |
| [refresh](refresh.md) | [androidJvm]<br>abstract suspend fun [refresh](refresh.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), page: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Refreshes series data by fetching it from the remote API. |
| [seriePagingSource](serie-paging-source.md) | [androidJvm]<br>abstract fun [seriePagingSource](serie-paging-source.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SeriePagingSource](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md)<br>Creates a paging source for series data. |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(item: [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md))<br>Updates a series in the local database. |
