//[app](../../../index.md)/[com.example.filmapplication.screens.serie](../index.md)/[SeriePagingSource](index.md)/[getRefreshKey](get-refresh-key.md)

# getRefreshKey

[androidJvm]\
open override fun [getRefreshKey](get-refresh-key.md)(state: [PagingState](https://developer.android.com/reference/kotlin/androidx/paging/PagingState.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?

Returns the refresh key for the current state, used to determine the starting point for loading when refreshing the data.

#### Return

The refresh key.

#### Parameters

androidJvm

| | |
|---|---|
| state | The current paging state. |
