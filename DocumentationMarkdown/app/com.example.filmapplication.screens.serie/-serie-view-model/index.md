//[app](../../../index.md)/[com.example.filmapplication.screens.serie](../index.md)/[SerieViewModel](index.md)

# SerieViewModel

class [SerieViewModel](index.md)(serieRepository: [SerieRepository](../../com.example.filmapplication.repository/-serie-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for managing TV series data and UI state.

#### Parameters

androidJvm

| | |
|---|---|
| serieRepository | The repository for accessing TV series data. |

## Constructors

| | |
|---|---|
| [SerieViewModel](-serie-view-model.md) | [androidJvm]<br>constructor(serieRepository: [SerieRepository](../../com.example.filmapplication.repository/-serie-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md)<br>Factory class for creating [SerieViewModel](index.md) instances. |

## Properties

| Name | Summary |
|---|---|
| [serieApiState](serie-api-state.md) | [androidJvm]<br>var [serieApiState](serie-api-state.md): [SerieApiState](../-serie-api-state/index.md)<br>Current state of the TV series API request. |
| [seriePager](serie-pager.md) | [androidJvm]<br>val [seriePager](serie-pager.md): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;&gt;<br>Flow representing the paged list of TV series retrieved from the API. |
| [serieTopRatedPager](serie-top-rated-pager.md) | [androidJvm]<br>val [serieTopRatedPager](serie-top-rated-pager.md): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md)&gt;&gt;<br>Flow representing the paged list of top-rated TV series retrieved from the API. |
| [uiListSerieState](ui-list-serie-state.md) | [androidJvm]<br>lateinit var [uiListSerieState](ui-list-serie-state.md): StateFlow&lt;[SerieListState](../-serie-list-state/index.md)&gt;<br>State flow representing the list of favorite TV series. |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [addSerieToFavourites](add-serie-to-favourites.md) | [androidJvm]<br>fun [addSerieToFavourites](add-serie-to-favourites.md)(serie: [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md))<br>Toggle the favorite status of a TV series and insert/update it in the database. |
| [getFavouriteSeries](get-favourite-series.md) | [androidJvm]<br>fun [getFavouriteSeries](get-favourite-series.md)()<br>Get the list of favorite TV series from the database. |
