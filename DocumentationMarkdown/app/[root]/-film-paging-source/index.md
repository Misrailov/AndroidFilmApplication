//[app](../../../index.md)/[[root]](../index.md)/[FilmPagingSource](index.md)

# FilmPagingSource

class [FilmPagingSource](index.md)(val filmRepository: [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md), val query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt; 

A [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html) for loading paged data of films from a [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md).

#### Parameters

androidJvm

| | |
|---|---|
| filmRepository | The repository responsible for fetching film data. |
| query | The query string used to search for films. |

## Constructors

| | |
|---|---|
| [FilmPagingSource](-film-paging-source.md) | [androidJvm]<br>constructor(filmRepository: [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md), query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [filmRepository](film-repository.md) | [androidJvm]<br>val [filmRepository](film-repository.md): [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md) |
| [invalid](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#-162919568%2FProperties%2F-912451524) | [androidJvm]<br>val [invalid](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#-162919568%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [jumpingSupported](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#242546777%2FProperties%2F-912451524) | [androidJvm]<br>open val [jumpingSupported](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#242546777%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyReuseSupported](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#-439827890%2FProperties%2F-912451524) | [androidJvm]<br>open val [keyReuseSupported](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#-439827890%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [query](query.md) | [androidJvm]<br>val [query](query.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [getRefreshKey](get-refresh-key.md) | [androidJvm]<br>open override fun [getRefreshKey](get-refresh-key.md)(state: [PagingState](https://developer.android.com/reference/kotlin/androidx/paging/PagingState.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?<br>Returns the refresh key for the PagingState. |
| [invalidate](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#1106667736%2FFunctions%2F-912451524) | [androidJvm]<br>fun [invalidate](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#1106667736%2FFunctions%2F-912451524)() |
| [load](load.md) | [androidJvm]<br>open suspend override fun [load](load.md)(params: [PagingSource.LoadParams](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadParams.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;): [PagingSource.LoadResult](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadResult.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;<br>Loads a page of paged film data. |
| [registerInvalidatedCallback](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#-395603798%2FFunctions%2F-912451524) | [androidJvm]<br>fun [registerInvalidatedCallback](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#-395603798%2FFunctions%2F-912451524)(onInvalidatedCallback: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [unregisterInvalidatedCallback](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#814983601%2FFunctions%2F-912451524) | [androidJvm]<br>fun [unregisterInvalidatedCallback](../../com.example.filmapplication.screens.serie/-serie-paging-source/index.md#814983601%2FFunctions%2F-912451524)(onInvalidatedCallback: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
