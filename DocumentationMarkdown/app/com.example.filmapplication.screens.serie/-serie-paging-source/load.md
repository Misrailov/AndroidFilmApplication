//[app](../../../index.md)/[com.example.filmapplication.screens.serie](../index.md)/[SeriePagingSource](index.md)/[load](load.md)

# load

[androidJvm]\
open suspend override fun [load](load.md)(params: [PagingSource.LoadParams](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadParams.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;): [PagingSource.LoadResult](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadResult.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;

Loads a page of TV series data based on the provided parameters.

#### Return

A LoadResult containing the loaded TV series data or an error.

#### Parameters

androidJvm

| | |
|---|---|
| params | The load parameters including the page key. |
