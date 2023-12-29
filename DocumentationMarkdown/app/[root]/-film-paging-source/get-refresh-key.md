//[app](../../../index.md)/[[root]](../index.md)/[FilmPagingSource](index.md)/[getRefreshKey](get-refresh-key.md)

# getRefreshKey

[androidJvm]\
open override fun [getRefreshKey](get-refresh-key.md)(state: [PagingState](https://developer.android.com/reference/kotlin/androidx/paging/PagingState.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?

Returns the refresh key for the PagingState.

#### Return

The refresh key, which is used to determine when to invalidate the data.

#### Parameters

androidJvm

| | |
|---|---|
| state | The current [PagingState](https://developer.android.com/reference/kotlin/androidx/paging/PagingState.html). |
