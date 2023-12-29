//[app](../../../index.md)/[[root]](../index.md)/[FilmPagingSource](index.md)/[load](load.md)

# load

[androidJvm]\
open suspend override fun [load](load.md)(params: [PagingSource.LoadParams](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadParams.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;): [PagingSource.LoadResult](https://developer.android.com/reference/kotlin/androidx/paging/PagingSource.LoadResult.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;

Loads a page of paged film data.

#### Return

A LoadResult containing the loaded data, previous and next keys, or an error.

#### Parameters

androidJvm

| | |
|---|---|
| params | Parameters for loading the page, including the page number. |
