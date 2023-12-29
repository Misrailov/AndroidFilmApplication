//[app](../../../index.md)/[com.example.filmapplication.screens.home](../index.md)/[HomeViewModel](index.md)

# HomeViewModel

class [HomeViewModel](index.md)(filmRepository: [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md), actorRepository: [ActorRepository](../../com.example.filmapplication.repository/-actor-repository/index.md), serieRepository: [SerieRepository](../../com.example.filmapplication.repository/-serie-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel class responsible for managing the Home screen state and data.

#### Parameters

androidJvm

| | |
|---|---|
| filmRepository | Repository for film-related data. |
| actorRepository | Repository for actor-related data. |
| serieRepository | Repository for serie-related data. |

## Constructors

| | |
|---|---|
| [HomeViewModel](-home-view-model.md) | [androidJvm]<br>constructor(filmRepository: [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md), actorRepository: [ActorRepository](../../com.example.filmapplication.repository/-actor-repository/index.md), serieRepository: [SerieRepository](../../com.example.filmapplication.repository/-serie-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [homeApiState](home-api-state.md) | [androidJvm]<br>var [homeApiState](home-api-state.md): [HomeApiState](../-home-api-state/index.md) |
| [uiListHomeState](ui-list-home-state.md) | [androidJvm]<br>lateinit var [uiListHomeState](ui-list-home-state.md): StateFlow&lt;[HomeListState](../-home-list-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [addActorToFavourites](add-actor-to-favourites.md) | [androidJvm]<br>fun [addActorToFavourites](add-actor-to-favourites.md)(actor: [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md))<br>Toggles the favorite status of an actor and updates it in the repository. |
| [addCloseable](../../com.example.filmapplication.screens.serie/-serie-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../com.example.filmapplication.screens.serie/-serie-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [addFilmToFavourites](add-film-to-favourites.md) | [androidJvm]<br>fun [addFilmToFavourites](add-film-to-favourites.md)(film: [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md))<br>Toggles the favorite status of a film and updates it in the repository. |
| [addSerieToFavourites](add-serie-to-favourites.md) | [androidJvm]<br>fun [addSerieToFavourites](add-serie-to-favourites.md)(serie: [DomainSerie](../../com.example.filmapplication.domain/-domain-serie/index.md))<br>Toggles the favorite status of a serie and updates it in the repository. |
| [getFavourites](get-favourites.md) | [androidJvm]<br>fun [getFavourites](get-favourites.md)()<br>Fetches and combines favorite films, series, and actors from repositories to populate the UI list. |
