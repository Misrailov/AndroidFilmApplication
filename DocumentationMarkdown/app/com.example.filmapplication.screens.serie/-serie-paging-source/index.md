//[app](../../../index.md)/[com.example.filmapplication.screens.serie](../index.md)/[SeriePagingSource](index.md)

# SeriePagingSource

class [SeriePagingSource](index.md)(val serieRepository: [SerieRepository](../../com.example.filmapplication.repository/-serie-repository/index.md), val query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt; 

A [PagingSource](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.html) implementation for loading paged TV series data.

#### Parameters

androidJvm

| | |
|---|---|
| serieRepository | The repository responsible for fetching TV series data. |
| query | The query string to filter the TV series. |

## Constructors

| | |
|---|---|
| [SeriePagingSource](-serie-paging-source.md) | [androidJvm]<br>constructor(serieRepository: [SerieRepository](../../com.example.filmapplication.repository/-serie-repository/index.md), query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [invalid](index.md#-162919568%2FProperties%2F-912451524) | [androidJvm]<br>val [invalid](index.md#-162919568%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [jumpingSupported](index.md#242546777%2FProperties%2F-912451524) | [androidJvm]<br>open val [jumpingSupported](index.md#242546777%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keyReuseSupported](index.md#-439827890%2FProperties%2F-912451524) | [androidJvm]<br>open val [keyReuseSupported](index.md#-439827890%2FProperties%2F-912451524): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [query](query.md) | [androidJvm]<br>val [query](query.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [serieRepository](serie-repository.md) | [androidJvm]<br>val [serieRepository](serie-repository.md): [SerieRepository](../../com.example.filmapplication.repository/-serie-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getRefreshKey](get-refresh-key.md) | [androidJvm]<br>open override fun [getRefreshKey](get-refresh-key.md)(state: [PagingState](https://developer.android.com/reference/kotlin/androidx/paging/PagingState.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?<br>Returns the refresh key for the current state, used to determine the starting point for loading when refreshing the data. |
| [invalidate](index.md#1106667736%2FFunctions%2F-912451524) | [androidJvm]<br>fun [invalidate](index.md#1106667736%2FFunctions%2F-912451524)() |
| [load](load.md) | [androidJvm]<br>open suspend override fun [load](load.md)(params: [PagingSource.LoadParams](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadParams.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;): [PagingSource.LoadResult](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadResult.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;<br>Loads a page of TV series data based on the provided parameters. |
| [registerInvalidatedCallback](index.md#-395603798%2FFunctions%2F-912451524) | [androidJvm]<br>fun [registerInvalidatedCallback](index.md#-395603798%2FFunctions%2F-912451524)(onInvalidatedCallback: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [unregisterInvalidatedCallback](index.md#814983601%2FFunctions%2F-912451524) | [androidJvm]<br>fun [unregisterInvalidatedCallback](index.md#814983601%2FFunctions%2F-912451524)(onInvalidatedCallback: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
