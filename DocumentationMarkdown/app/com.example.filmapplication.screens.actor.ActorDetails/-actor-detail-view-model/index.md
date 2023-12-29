//[app](../../../index.md)/[com.example.filmapplication.screens.actor.ActorDetails](../index.md)/[ActorDetailViewModel](index.md)

# ActorDetailViewModel

class [ActorDetailViewModel](index.md)(actorRepository: [ActorRepository](../../com.example.filmapplication.repository/-actor-repository/index.md), filmRepository: [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel class for the Actor Detail screen.

#### Parameters

androidJvm

| | |
|---|---|
| actorRepository | The repository for actor-related data. |
| filmRepository | The repository for film-related data. |

## Constructors

| | |
|---|---|
| [ActorDetailViewModel](-actor-detail-view-model.md) | [androidJvm]<br>constructor(actorRepository: [ActorRepository](../../com.example.filmapplication.repository/-actor-repository/index.md), filmRepository: [FilmRepository](../../com.example.filmapplication.repository/-film-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [actorDetailViewUiState](actor-detail-view-ui-state.md) | [androidJvm]<br>var [actorDetailViewUiState](actor-detail-view-ui-state.md): [ActorDetailViewUiState](../-actor-detail-view-ui-state/index.md)<br>Current UI state for the Actor Detail screen. |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../com.example.filmapplication.screens.serie/-serie-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../com.example.filmapplication.screens.serie/-serie-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [addFilmToFavourites](add-film-to-favourites.md) | [androidJvm]<br>fun [addFilmToFavourites](add-film-to-favourites.md)(film: [DomainFilm](../../com.example.filmapplication.domain/-domain-film/index.md))<br>Toggles the favorite status of a film and updates the repository. |
| [getActorDetails](get-actor-details.md) | [androidJvm]<br>fun [getActorDetails](get-actor-details.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Fetches actor details and associated films. |
