//[app](../../../index.md)/[com.example.filmapplication.screens.actor](../index.md)/[ActorViewModel](index.md)

# ActorViewModel

class [ActorViewModel](index.md)(actorRepository: [ActorRepository](../../com.example.filmapplication.repository/-actor-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel class for managing actor-related data and UI states.

#### Parameters

androidJvm

| | |
|---|---|
| actorRepository | The repository for actor-related data. |
| filmRepository | The repository for film-related data. |

## Constructors

| | |
|---|---|
| [ActorViewModel](-actor-view-model.md) | [androidJvm]<br>constructor(actorRepository: [ActorRepository](../../com.example.filmapplication.repository/-actor-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [actorApiState](actor-api-state.md) | [androidJvm]<br>var [actorApiState](actor-api-state.md): [ActorApiState](../-actor-api-state/index.md)<br>The current state of actor API call, represented by [ActorApiState](../-actor-api-state/index.md). |
| [uiListActorState](ui-list-actor-state.md) | [androidJvm]<br>lateinit var [uiListActorState](ui-list-actor-state.md): StateFlow&lt;[ActorListState](../-actor-list-state/index.md)&gt;<br>A StateFlow representing the list of actors and their favorite status. |

## Functions

| Name | Summary |
|---|---|
| [addActorToFavourites](add-actor-to-favourites.md) | [androidJvm]<br>fun [addActorToFavourites](add-actor-to-favourites.md)(actor: [DomainActor](../../com.example.filmapplication.domain/-domain-actor/index.md))<br>Toggles the favorite status of an actor and inserts the updated data into the repository. |
| [addCloseable](../../com.example.filmapplication.screens.serie/-serie-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../../com.example.filmapplication.screens.serie/-serie-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [getRepoActors](get-repo-actors.md) | [androidJvm]<br>fun [getRepoActors](get-repo-actors.md)()<br>Fetches actor data from the repository, updates the UI states, and handles API call results. |
