//[app](../../../index.md)/[com.example.filmapplication.screens.film](../index.md)/[FilmViewModel](index.md)

# FilmViewModel

class [FilmViewModel](index.md)(filmRepository: [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for the Film screen.

#### Parameters

androidJvm

| | |
|---|---|
| filmRepository | The repository for film-related data. |

## Constructors

| | |
|---|---|
| [FilmViewModel](-film-view-model.md) | [androidJvm]<br>constructor(filmRepository: [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [apiFilmPager](api-film-pager.md) | [androidJvm]<br>val [apiFilmPager](api-film-pager.md): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;&gt;<br>Flow of [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) for the top box office films. |
| [apiFilmPagerTopRated](api-film-pager-top-rated.md) | [androidJvm]<br>val [apiFilmPagerTopRated](api-film-pager-top-rated.md): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;&gt;<br>Flow of [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) for the top-rated films. |
| [apiFilmPagerWorstMovies](api-film-pager-worst-movies.md) | [androidJvm]<br>val [apiFilmPagerWorstMovies](api-film-pager-worst-movies.md): Flow&lt;[PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html)&lt;[DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md)&gt;&gt;<br>Flow of [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData.html) for the worst-rated movies. |
| [filmApiState](film-api-state.md) | [androidJvm]<br>var [filmApiState](film-api-state.md): [FilmApiState](../-film-api-state/index.md)<br>Represents the state of the film-related API call. |
| [uiListFilmState](ui-list-film-state.md) | [androidJvm]<br>lateinit var [uiListFilmState](ui-list-film-state.md): StateFlow&lt;[FilmListState](../-film-list-state/index.md)&gt;<br>Flow of [FilmListState](../-film-list-state/index.md) containing favorite films. |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../com.example.filmapplication.screens.serie/-serie-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../com.example.filmapplication.screens.serie/-serie-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [addFilmToFavourites](add-film-to-favourites.md) | [androidJvm]<br>fun [addFilmToFavourites](add-film-to-favourites.md)(film: [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md))<br>Toggles the favorite status of a film and updates the database. |
| [getFavouriteFilms](get-favourite-films.md) | [androidJvm]<br>fun [getFavouriteFilms](get-favourite-films.md)()<br>Retrieves favorite films and sets the [uiListFilmState](ui-list-film-state.md) accordingly. |
